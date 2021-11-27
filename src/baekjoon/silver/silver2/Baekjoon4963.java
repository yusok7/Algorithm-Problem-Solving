package baekjoon.silver.silver2;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Baekjoon4963 {

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

    // 상, 하, 좌, 우, 대각선 위 왼쪽, 대각선 위 오른쪽, 대각선 아래 왼쪽, 대각선 아래 오른쪽
    public static int[] dx = {-1, 1, 0, 0, -1, -1, 1, 1};
    public static int[] dy = {0, 0, -1, 1, -1, 1, -1, 1};
    public static int[][] arr;
    public static int result = 0;

    public static Queue<Node> queue = new LinkedList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        while (true) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            if (x == 0 && y == 0) break;

            arr = new int[y][x];

            for (int i = 0; i < y; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < x; j++) {
                    arr[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            for (int i = 0; i < y; i++) {
                for (int j = 0; j < x; j++) {
                    if (arr[i][j] == 1) {
                        queue.add(new Node(i, j));
                        bfs();
                        result++;
                    }
                }
            }

            bw.write(String.valueOf(result));
            bw.write("\n");
            result = 0;
        }
        bw.flush();
        bw.close();
        br.close();
    }

    public static void bfs() {
        while (!queue.isEmpty()) {
            Node node = queue.poll();
            int x = node.getX();
            int y = node.getY();
            arr[x][y] = 0;
            for (int i = 0; i < 8; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];
                if (nx < 0 || ny < 0 || nx >= arr.length || ny >= arr[0].length) {
                    continue;
                }
                if (arr[nx][ny] == 1) {
                    arr[nx][ny] = 0;
                    queue.add(new Node(nx, ny));
                }
            }
        }
    }
}
