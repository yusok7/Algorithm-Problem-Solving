package baekjoon.gold.gold5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Baekjoon20166 {

    private static int n, m, k;
    private static String[][] arr;

    private static Map<String, Integer> map = new HashMap<>();
    private static Map<String, Integer> map2 = new HashMap<>();

    // 북, 동, 남, 서, 오른쪽 대각선 위, 오른쪽 대각선 아래, 왼쪽 대각선 아래, 왼쪽 대각선 위
    private static int[] dx = {-1, 0, 1, 0, -1, 1, 1, -1};
    private static int[] dy = {0, 1, 0, -1, 1, 1, -1, -1};

    public static void main(String[] args) throws IOException {
        List<String> list = new ArrayList<>();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        arr = new String[n][m];

        for (int i = 0; i < n; i++) {
            String str = br.readLine();
            for (int j = 0; j < m; j++) {
                arr[i][j] = String.valueOf(str.charAt(j));
            }
        }

        for (int i = 0; i < k; i++) {
            String s = br.readLine();
            map2.put(s, 0);
            list.add(s);
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                String s = arr[i][j];
                dfs(i, j, 1, s);
            }
        }

        func();

        StringBuilder sb = new StringBuilder();
        for (String s : list) {
            if (map.containsKey(s)) {
                Integer val = map.get(s);
                sb.append(val).append("\n");
            } else
                sb.append(0).append("\n");
        }

        System.out.println(sb.toString());
    }

    private static void dfs(int x, int y, int depth, String s) {
        if (depth == 5)
            return;

        for (int i = 0; i < 8; i++) {
            StringBuilder sb = new StringBuilder();
            int nx = x + dx[i];
            int ny = y + dy[i];
            if (nx >= 0 && ny >= 0 && nx < n && ny < m) {
                sb.append(s).append(arr[nx][ny]);
                String str = sb.toString();
                check(str);
                dfs(nx, ny, depth + 1, str);
            } else {
                if (nx < 0)
                    nx = n - 1;
                if (nx >= n)
                    nx = 0;
                if (ny < 0)
                    ny = m - 1;
                if (ny >= m)
                    ny = 0;
                sb.append(s).append(arr[nx][ny]);
                String str = sb.toString();
                check(str);
                dfs(nx, ny, depth + 1, str);
            }
        }
    }

    private static void check(String str) {
        if (map2.containsKey(str))
            map.put(str, map.getOrDefault(str, 0) + 1);
    }

    private static void func() {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                String s = arr[i][j];
                map.put(s, map.getOrDefault(s, 0) + 1);
            }
        }
    }
}
