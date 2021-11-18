package baekjoon.silver.silver1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Baekjoon7576 {

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

    public static int[][] arr;
    public static Queue<Node> queue = new LinkedList<>();
    public static List<Integer> result = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        m = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());
        arr = new int[n][m];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        boolean bool = false;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (arr[i][j] == 0) {
                    bool = true;
                } else if (arr[i][j] == 1) {
                    queue.add(new Node(i, j));
                }
            }
        }

        if (!bool) {
            System.out.println(0);
            System.exit(0);
        }

        bfs();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                result.add(arr[i][j]);
            }
        }

        if (result.contains(0)) {
            System.out.println(-1);
            System.exit(0);
        }

        System.out.println(Collections.max(result) - 1);
    }

    public static void bfs() {
        while (!queue.isEmpty()) {
            Node node = queue.poll();
            int x = node.getX();
            int y = node.getY();
            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];
                if (nx < 0 || ny < 0 || nx >= n || ny >= m) continue;
                if (arr[nx][ny] == -1) continue;
                if (arr[nx][ny] == 0) {
                    arr[nx][ny] = arr[x][y] + 1;
                    queue.add(new Node(nx, ny));
                }
            }
        }
    }
}
