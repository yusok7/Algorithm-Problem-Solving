package baekjoon.silver.silver1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Baekjoon2468 {

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

    public static int n;
    public static int max = 0;
    public static int result = 0;
    public static Queue<Node> queue = new LinkedList<>();
    public static List<Integer> list = new ArrayList<>();

    // 상 하 좌 우
    public static int[] dx = {0, 0, -1, 1};
    public static int[] dy = {-1, 1, 0, 0};

    public static int[][] arr;
    public static int[][] arr2;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        arr = new int[n][n];
        arr2 = new int[n][n];

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < n; j++) {
                int val = Integer.parseInt(st.nextToken());
                max = Math.max(max, val);
                arr[i][j] = val;
                arr2[i][j] = val;
            }
        }

        for (int i = 0; i <= max; i++) { // 비의 양
            copy();
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < n; k++) {
                    if (arr[j][k] <= i) {
                        arr[j][k] = 0;
                    }
                }
            }
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < n; k++) {
                    if (arr[j][k] != 0) {
                        queue.add(new Node(j, k));
                        bfs();
                        result++;
                    }
                }
            }
            list.add(result);
            result = 0;
        }

        System.out.println(Collections.max(list));

    }

    public static void bfs() {
        while (!queue.isEmpty()) {
            Node node = queue.poll();
            int x = node.getX();
            int y = node.getY();
            arr[x][y] = 0;
            for (int i = 0; i < dx.length; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];
                if (nx < 0 || ny < 0 || nx >=n || ny >= n) {
                    continue;
                }
                if (arr[nx][ny] != 0) {
                    queue.add(new Node(nx, ny));
                    arr[nx][ny] = 0;
                }
            }
        }
    }

    public static void copy() {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                arr[i][j] = arr2[i][j];
            }
        }
    }
}
