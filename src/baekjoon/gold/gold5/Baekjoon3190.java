package baekjoon.gold.gold5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Baekjoon3190 {

    static class Node {
        int x;
        int y;

        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Node node = (Node) o;
            return x == node.x && y == node.y;
        }

        @Override
        public int hashCode() {
            return Objects.hash(x, y);
        }
    }

    private static LinkedList<Node> queue = new LinkedList<>();
    private static List<Node> list = new ArrayList<>();
    private static Map<Integer, String> map = new HashMap<>();

    // 북 동 남 서
    private static int[] dx = {-1, 0, 1, 0};
    private static int[] dy = {0, 1, 0, -1};

    private static int direction = 1;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int k = Integer.parseInt(br.readLine());
        for (int i = 0; i < k; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken()) - 1;
            int y = Integer.parseInt(st.nextToken()) - 1;
            Node node = new Node(x, y);
            list.add(node);
        }

        int l = Integer.parseInt(br.readLine());
        for (int i = 0; i < l; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int time = Integer.parseInt(st.nextToken());
            String str = st.nextToken();
            map.put(time, str);
        }

        int time = 0;
        int x = 0;
        int y = 0;
        queue.add(new Node(x, y));
        while (true) {
            time++;
            int nx = x + dx[direction];
            int ny = y + dy[direction];
            Node node = new Node(nx, ny);
            if (nx < 0 || ny < 0 || nx >= n || ny >= n)
                break;
            if (queue.contains(node))
                break;

            // 이동한 칸에 사과가 있는 경우
            if (list.contains(node)) {
                list.remove(node);
                queue.add(node);
                x = nx;
                y = ny;
            }
            else { // 사과가 없는 경우
                queue.add(node);
                queue.poll();
                x = nx;
                y = ny;
            }

            if (map.containsKey(time)) {
                String val = map.get(time);
                if (val.equals("D"))
                    turnRight();
                else
                    turnLeft();
            }
        }
        System.out.println(time);
    }

    private static void turnLeft() {
        direction -= 1;
        if (direction == -1)
            direction = 3;
    }

    private static void turnRight() {
        direction += 1;
        if (direction == 4)
            direction = 0;
    }
}
