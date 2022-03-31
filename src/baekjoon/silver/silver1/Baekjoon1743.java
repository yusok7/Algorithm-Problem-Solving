package baekjoon.silver.silver1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baekjoon1743 {

    private static boolean[][] visit;
    private static String[][] arr;

    private static int answer = 0;
    private static int count = 0;
    private static int n, m, k;

    // 북 동 남 서
    private static int[] dx = {-1, 0, 1, 0};
    private static int[] dy = {0, 1, 0, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        visit = new boolean[n][m];
        arr = new String[n][m];

        for (int i = 0; i < n; i++)
            for (int j = 0; j < m; j++)
                arr[i][j] = ".";

        for (int i = 0; i < k; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken()) - 1;
            int y = Integer.parseInt(st.nextToken()) - 1;
            arr[x][y] = "#";
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (arr[i][j].equals("#"))
                    dfs(i, j);
                answer = Math.max(answer, count);
                count = 0;
            }
        }
        System.out.println(answer);
    }

    private static void dfs(int x, int y) {
        if (x < 0 || y < 0 || x >= n || y >= m)
            return;

        if (visit[x][y] == true || arr[x][y].equals("."))
            return;

        if (arr[x][y].equals("#")) {
            visit[x][y] = true;
            count++;
        }

        for (int i = 0; i < 4; i++)
            dfs(x + dx[i], y + dy[i]);
        return;
    }
}
