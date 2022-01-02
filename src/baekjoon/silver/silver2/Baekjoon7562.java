package baekjoon.silver.silver2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Baekjoon7562 {

    static class Node {
        int x;
        int y;
        int count;

        public Node(int x, int y, int count) {
            this.x = x;
            this.y = y;
            this.count = count;
        }

        public int getX() {
            return x;
        }

        public int getY() {
            return y;
        }

        public int getCount() {
            return count;
        }
    }

    public static int dx[] = {-1, -2, -2, -1, 1, 2, 2, 1};
    public static int dy[] = {-2, -1, 1, 2, 2, 1, -1, -2};

    public static int n;
    public static int[][] arr;

    public static Queue<Node> queue = new LinkedList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int index = Integer.parseInt(br.readLine());

        for (int i = 0; i < index; i++) {

            n = Integer.parseInt(br.readLine());
            arr = new int[n][n];

            StringTokenizer st = new StringTokenizer(br.readLine());
            int startX = Integer.parseInt(st.nextToken());
            int startY = Integer.parseInt(st.nextToken());

            st = new StringTokenizer(br.readLine());
            int finalX = Integer.parseInt(st.nextToken());
            int finalY = Integer.parseInt(st.nextToken());

            if (startX == finalX && startY == finalY) {
                System.out.println(0);
                continue;
            }

            queue.add(new Node(startX, startY, 0));

            while (!queue.isEmpty()) {
                Node node = queue.poll();
                int x = node.getX();
                int y = node.getY();
                int count = node.getCount();
                for (int j = 0; j < 8; j++) {
                    int nx = x + dx[j];
                    int ny = y + dy[j];
                    if (nx < 0 || ny < 0 || nx >=n || ny >= n) continue;
                    if (arr[nx][ny] != 0) continue;
                    arr[nx][ny] = count + 1;
                    queue.add(new Node(nx, ny, count + 1));
                }
            }
            System.out.println(arr[finalX][finalY]);
            // 큐 초기화
            queue.clear();
        }
    }
}
