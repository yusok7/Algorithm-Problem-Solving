package baekjoon.silver.silver1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baekjoon11660 {

    private static int[][] arr;
    private static long[][] sumArr;

    public static void main(String[] args) throws IOException {
        StringBuilder sb = new StringBuilder();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        arr = new int[n][n];
        sumArr = new long[n][n];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < n; i++) {
            long sum = 0;
            for (int j = 0; j < n; j++) {
                sum += arr[i][j];
                sumArr[i][j] = sum;
            }
        }

        for (int t = 0; t < m; t++) {
            st = new StringTokenizer(br.readLine());
            int row1 = Integer.parseInt(st.nextToken()) - 1;
            int col1 = Integer.parseInt(st.nextToken()) - 1;
            int row2 = Integer.parseInt(st.nextToken()) - 1;
            int col2 = Integer.parseInt(st.nextToken()) - 1;

            long answer = 0;
            for (int i = row1; i <= row2; i++) {
                if (col2 == 0) col2 = 0;
                if (col1 - 1 == -1)
                    answer += sumArr[i][col2];
                else
                    answer += sumArr[i][col2] - sumArr[i][col1 - 1];
            }
            sb.append(answer).append("\n");
        }
        System.out.println(sb.toString());
    }
}
