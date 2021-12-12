package baekjoon.silver.silver3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Baekjoon2193 {

    public static long[] dp = new long[91];

    public static void main(String[] args) throws IOException {
        func();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println(dp[Integer.parseInt(br.readLine())]);
    }

    public static void func() {
        dp[1] = dp[2] = 1;
        for (int i = 3; i <= 90; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
    }
}
