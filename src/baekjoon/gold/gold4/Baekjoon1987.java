package baekjoon.gold.gold4;

import java.io.*;
import java.util.*;
import java.util.Map;

public class Baekjoon1987 {

    private static int n, m;
    private static int answer = 1;
    private static String[][] arr;
    private static boolean[][] visit;

    private static Map<String, Integer> map = new HashMap<>();

    // 북 동 남 서
    private static int[] dx = {-1, 0, 1, 0};
    private static int[] dy = {0, 1, 0, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        arr = new String[n][m];
        visit = new boolean[n][m];

        for (int i = 0; i < n; i++) {
            String str = br.readLine();
            for (int j = 0; j < str.length(); j++) {
                arr[i][j] = String.valueOf(str.charAt(j));
            }
        }
        map.put(arr[0][0], 0);
        dfs(0, 0, 1);
        System.out.println(answer);
    }

    private static void dfs(int x, int y, int count) {
        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            if (nx < 0 || ny < 0 || nx >= n || ny >= m)
                continue;
            if (visit[nx][ny] == true)
                continue;
            if (map.containsKey(arr[nx][ny]))
                continue;

            if (!visit[nx][ny]) {
                visit[nx][ny] = true;
                map.put(arr[nx][ny], 0);
                answer = Math.max(answer, count + 1);
                dfs(nx, ny, count + 1);
                visit[nx][ny] = false;
                map.remove(arr[nx][ny]);
            }
        }
    }
}
