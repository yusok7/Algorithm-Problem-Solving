package baekjoon.silver.silver1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Baekjoon2583 {

    private static int n, m, k;
    private static int[][] arr;

    // 북 동 남 서
    private static int[] dx = {0, 1, 0, -1};
    private static int[] dy = {-1, 0, 1, 0};

    private static Queue<int[]> queue = new LinkedList<>();

    private static List<Integer> list = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken()); // y (세로)
        m = Integer.parseInt(st.nextToken()); // x (가로)
        int k = Integer.parseInt(st.nextToken());

        arr = new int[n][m];

        for (int i = 0; i < k; i++) {
            st = new StringTokenizer(br.readLine());
            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken()) - 1;
            int y2 = Integer.parseInt(st.nextToken()) - 1;

            for (int a = y1; a <= y2; a++) {
                for (int b = x1; b <= x2; b++) {
                    arr[a][b] = 1;
                }
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (arr[i][j] == 0) {
                    queue.add(new int[] {i, j});
                    bfs();
                }
            }
        }

        Collections.sort(list);

        StringBuilder sb = new StringBuilder();
        for (Integer val : list) {
            sb.append(val).append(" ");
        }

        System.out.println(list.size());
        System.out.println(sb.toString());
    }

    private static void bfs() {
        int result = 0;
        while (!queue.isEmpty()) {
            result++;
            int[] poll = queue.poll();
            int x = poll[1];
            int y = poll[0];
            arr[y][x] = 1;
            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];
                if (nx < 0 || ny < 0 || nx >= m || ny >= n)
                    continue;
                if (arr[ny][nx] == 1)
                    continue;
                queue.add(new int[]{ny, nx});
                arr[ny][nx] = 1;
            }
        }
        list.add(result);
    }
}
