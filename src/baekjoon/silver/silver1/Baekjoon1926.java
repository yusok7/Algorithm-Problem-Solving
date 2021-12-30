package baekjoon.silver.silver1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Baekjoon1926 {

    static class Node {
        int x;
        int y;

        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public int getX() {
            return x;
        }

        public int getY() {
            return y;
        }
    }

    // 동, 서, 남, 북
    public static int[] dx = {1, -1, 0, 0};
    public static int[] dy = {0, 0, 1, -1};

    public static int n;
    public static int m;

    public static Queue<Node> queue = new LinkedList<>();
    public static List<Integer> list = new ArrayList<>();

    public static int[][] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        arr = new int[n][m];

        // 초기화
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                int num = Integer.parseInt(st.nextToken());
                arr[i][j] = num;
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (arr[i][j] == 1) {
                    Node node = new Node(i, j);
                    queue.add(node);
                    arr[i][j] = -1;
                    bfs();
                }
            }
        }

        if (list.size() == 0) {
            System.out.println(0);
            System.out.println(0);
        } else {
            System.out.println(list.size());
            System.out.println(Collections.max(list));
        }

    }

    public static void bfs() {
        int result = 1;
        while (!queue.isEmpty()) {
            Node poll = queue.poll();
            int x = poll.getX();
            int y = poll.getY();
            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];
                if (nx < 0 || ny < 0 || nx >= n || ny >= m) continue;
                else {
                    if (arr[nx][ny] == 1) {
                        queue.add(new Node(nx, ny));
                        arr[nx][ny] = -1;
                        result++;
                    }
                }
            }
        }
        list.add(result);
    }
}
