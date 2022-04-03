package baekjoon.silver.silver3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Baekjoon3085 {

    private static int n;
    private static int answer = 0;
    private static String[][] arr;
    private static String[][] copy;

    private static int[] dx = {1, 0};
    private static int[] dy = {0, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        arr = new String[n][n];

        for (int i = 0; i < n; i++) {
            String str = br.readLine();
            for (int j = 0; j < n; j++) {
                String s = String.valueOf(str.charAt(j));
                arr[i][j] = s;
            }
        }

        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - 1; j++) {
                if (!arr[i][j].equals(arr[i][j + 1])) {
                    func(i, j, arr[i][j], arr[i][j + 1], true);
                }
                if (!arr[i][j].equals(arr[i + 1][j])) {
                    func(i, j, arr[i][j], arr[i + 1][j], false);
                }
            }
        }
        for (int i = 0; i < n - 1; i++) {
            if (!arr[n - 1][i].equals(arr[n - 1][i + 1])) {
                func(n - 1, i, arr[n - 1][i], arr[n - 1][i + 1], true);
            }
        }
        System.out.println(answer);
    }

    private static void func(int i, int j, String s1, String s2, boolean bool) {
        copy = new String[n][n];
        if (bool) {
            copy[i][j] = s2;
            copy[i][j + 1] = s1;
        } else {
            copy[i][j] = s2;
            copy[i + 1][j] = s1;
        }

        for (int a = 0; a < n; a++) {
            for (int b = 0; b < n; b++) {
                if (copy[a][b] == null)
                    copy[a][b] = arr[a][b];
            }
        }

        for (int a = 0; a < n; a++) {
            for (int b = 0; b < n; b++) {
                String s = copy[a][b];
                // 오른쪽으로
                int count = 1;
                int aX = a;
                int aY = b;
                while (true) {
                    int nx = aX + dx[1];
                    int ny = aY + dy[1];
                    if (ny >= n)
                        break;
                    if (copy[nx][ny].equals(s)) {
                        count++;
                        aX = nx;
                        aY = ny;
                    } else {
                        break;
                    }
                }
                answer = Math.max(count, answer);

                // 아래로
                count = 1;
                aX = a;
                aY = b;
                while (true) {
                    int nx = aX + dx[0];
                    int ny = aY + dy[0];
                    if (nx >= n)
                        break;
                    if (copy[nx][ny].equals(s)) {
                        count++;
                        aX = nx;
                        aY = ny;
                    } else {
                        break;
                    }
                }
                answer = Math.max(count, answer);
            }
        }
    }
}
