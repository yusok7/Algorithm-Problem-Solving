package matchhere.d10recursive;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * n = 20까지여서
 * 다이나믹 알고리즘으로 구현한 것과 비교 시 시간 측면에서 큰 차이 x
 * 다이나믹 : 124ms
 * 재귀 : 132ms
 */

public class Baekjoon10870 {

    public static int[] arr = new int[21];

    public static void main(String[] args) throws IOException {
        arr[0] = 0;
        arr[1] = 1;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        System.out.println(fibo(n));
    }

    /**
     * 이 부분이 절차지향적이 아니라
     * 어떻게 귀납법 접근으로 가능한지 생각해보자
     */
    public static int fibo(int n) {
        if (n <= 1) {
            return arr[n];
        }
        return fibo(n-1) + fibo(n-2);
    }
}
