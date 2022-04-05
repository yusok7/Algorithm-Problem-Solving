package baekjoon.silver.silver1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Baekjoon16935 {

    private static int n, m, k;
    private static int[][] arr;
    private static int[][] copy;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        arr = new int[n][m];
        copy = new int[n][m];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        Queue<Integer> queue = new LinkedList<>();
        st = new StringTokenizer(br.readLine());
        while (st.hasMoreTokens())
            queue.add(Integer.parseInt(st.nextToken()));

        for (int t = 0; t < k; t++) {
            int input = queue.poll();
            if (input == 1) {
                func1();
                copyArr();
            } else if (input == 2) {
                func2();
                copyArr();
            } else if (input == 3) {
                func3();
                copyArr();
            } else if (input == 4) {
                func4();
                copyArr();
            } else if (input == 5) {
                func5();
                copyArr();
            } else if (input == 6) {
                func6();
                copyArr();
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                sb.append(arr[i][j]).append(" ");
            }
            sb.append("\n");
        }
        System.out.println(sb.toString());
    }

    private static void copyArr() {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                arr[i][j] = copy[i][j];
            }
        }
    }

    private static void func1() {
        int idx = 0;
        for (int i = arr.length - 1; i >= 0; i--) {
            for (int j = 0; j < arr[0].length; j++) {
                copy[idx][j] = arr[i][j];
            }
            idx++;
        }
    }

    private static void func2() {
        for (int i = 0; i < arr.length; i++) {
            int idx = 0;
            for (int j = arr[0].length - 1; j >= 0; j--) {
                copy[i][idx++] = arr[i][j];
            }
        }
    }

    private static void func3() {
        int a;
        copy = new int[m][n];
        int idx1 = 0;
        for (int j = 0; j < m; j++) {
            int idx2 = 0;
            for (int i = n - 1; i >= 0; i--) {
                copy[idx1][idx2++] = arr[i][j];
            }
            idx1++;
        }
        a = n;
        n = m;
        m = a;
        arr = new int[n][m];
    }

    private static void func4() {
        int a;
        copy = new int[m][n];
        int idx1 = 0;
        for (int j = m - 1; j >= 0; j--) {
            int idx2 = 0;
            for (int i = 0; i < n; i++) {
                copy[idx1][idx2++] = arr[i][j];
            }
            idx1++;
        }
        a = n;
        n = m;
        m = a;
        arr = new int[n][m];
    }

    private static void func5() {
        int row = n / 2;
        int col = m / 2;

        // 1 -> 2
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                copy[i][j + col] = arr[i][j];
            }
        }

        // 2 -> 3
        for (int i = 0; i < row; i++) {
            for (int j = col; j < m; j++) {
                copy[i + row][j] = arr[i][j];
            }
        }

        // 3 -> 4
        for (int i = row; i < n; i++) {
            for (int j = col; j < m; j++) {
                copy[i][j - col] = arr[i][j];
            }
        }

        // 4 -> 1
        for (int i = row; i < n; i++) {
            for (int j = 0; j < col; j++) {
                copy[i - row][j] = arr[i][j];
            }
        }
    }

    private static void func6() {
        int row = n / 2;
        int col = m / 2;

        // 1 -> 4
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                copy[i + row][j] = arr[i][j];
            }
        }

        // 2 -> 1
        for (int i = 0; i < row; i++) {
            for (int j = col; j < m; j++) {
                copy[i][j - col] = arr[i][j];
            }
        }

        // 3 -> 2
        for (int i = row; i < n; i++) {
            for (int j = col; j < m; j++) {
                copy[i - row][j] = arr[i][j];
            }
        }

        // 4 -> 3
        for (int i = row; i < n; i++) {
            for (int j = 0; j < col; j++) {
                copy[i][j + col] = arr[i][j];
            }
        }
    }
}
