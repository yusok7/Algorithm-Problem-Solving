package baekjoon.silver.silver2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baekjoon1182 {

    /**
     * 원소 n개를 가진 집합의 부분집합의 개수는 2^n 이다.
     */

    private static int n, s;
    private static int[] arr;
    private static int result = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        s = Integer.parseInt(st.nextToken());
        arr = new int[n];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        backtracking(0, 0);
        if (s == 0)
            result--;
        System.out.println(result);

    }

    private static void backtracking(int cur, int sum) {
        if (cur == n) {
            if (sum == s) result++;
            return;
        }
        backtracking(cur + 1, sum); // 현재 index에 해당하는 원소를 더하지 않고
        backtracking(cur + 1, sum + arr[cur]); // 현재 index에 해당하는 원소를 더하고
    }
}
