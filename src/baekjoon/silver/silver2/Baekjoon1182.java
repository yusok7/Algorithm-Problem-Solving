package baekjoon.silver.silver2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baekjoon1182 {

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
        backtracking(cur + 1, sum);
        backtracking(cur + 1, sum + arr[cur]);
    }
}
