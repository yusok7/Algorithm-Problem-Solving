package baekjoon.gold.gold5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Baekjoon2636 {

    private static String[][] arr;
    private static boolean[][] visit;
    private static int n, m;

    private static int[] dx = {-1, 0, 1, 0};
    private static int[] dy = {0, 1, 0, -1};

    private static Queue<int[]> queue = new LinkedList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        arr = new String[n][m];
        visit = new boolean[n][m];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                arr[i][j] = st.nextToken();
            }
        }

        if (is()) {
            System.out.println(0 + "\n" + 0);
            System.exit(0);
        }

        int answer = 0;
        int count;
        while (true) {
            answer++;
            count = check();
            queue.add(new int[] {0, 0});
            func();
            func2();
            if (is())
                break;
            for (int i = 0; i < n; i++)
                for (int j = 0; j < m; j++)
                    visit[i][j] = false;
        }
        System.out.println(answer);
        System.out.println(count);
    }

    private static void func() {
        while (!queue.isEmpty()) {
            int[] poll = queue.poll();
            int x = poll[0];
            int y = poll[1];
            visit[x][y] = true;
            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];
                if (nx < 0 || ny < 0 || nx >= n || ny >= m)
                    continue;
                if (visit[nx][ny] == true)
                    continue;
                if (arr[nx][ny].equals("0")) {
                    queue.add(new int[]{nx, ny});
                    visit[nx][ny] = true;
                }
                if (arr[nx][ny].equals("1"))
                    arr[nx][ny] = "C";
            }
        }
    }

    private static void func2() {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (arr[i][j].equals("C"))
                    arr[i][j] = "0";
            }
        }
    }

    private static int check() {
        int count = 0;
        for (int i = 0; i < n; i++)
            for (int j = 0; j < m; j++)
                if (arr[i][j].equals("1"))
                    count++;
        return count;
    }

    private static boolean is() {
        for (int i = 0; i < n; i++)
            for (int j = 0; j < m; j++)
                if (arr[i][j].equals("1"))
                    return false;
        return true;
    }
}
