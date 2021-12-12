package baekjoon.silver.silver3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Baekjoon1699 {

    public static int[] dp = new int[100001];

    public static void main(String[] args) throws IOException {
        func();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        for (int i = 1; i <= 100000; i++) {
            if (dp[i] != 0) continue; // 초기화 됐다면 넘어가기 (제곱수)
            else {
                int min = Integer.MAX_VALUE;
                for (int j = 1; j <= 100000; j++) {
                    if (j * j > i) {
                        break;
                    } else {
                        min = Math.min(min, dp[j * j] + dp[i - j * j]);
                    }
                }
                dp[i] = min;
            }
        }

        System.out.println(dp[n]);
    }

    // 제곱 수 초기화
    public static void func() {

        dp[1] = 1;
        dp[2] = 2;
        dp[3] = 3;
        int n = 100000;

        for (int i = 2; i <= n; i++) {
            if (i * i <= n) {
                dp[i * i] = 1;
            } else {
                break;
            }
        }
    }
}
