package baekjoon.silver.silver1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Baekjoon11057 {

    public static long[][] dp = new long[1001][10];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        func();

        for (int i = 2; i <= n; i++) { // dp[2][] ....
            for (int j = 0; j < 10; j++) {
                for (int k = j; k < 10; k++) {// dp[2][1], dp[2][2], dp[2][3].....
                    dp[i][k] += dp[i-1][j] % 10007;
                }
            }
        }

        long result = 0;
        for (int i = 0; i < 10; i++) {
            result += dp[n][i];
        }

        System.out.println(result % 10007);
    }

    public static void func() {
        for (int i = 0; i < 10; i++) {
            dp[1][i] = 1;
        }
    }
}
