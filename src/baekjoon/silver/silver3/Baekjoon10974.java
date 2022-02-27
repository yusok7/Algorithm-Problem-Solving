package baekjoon.silver.silver3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Baekjoon10974 {

    private static int n, m;
    private static int[] arr;
    private static int[] result;
    private static boolean[] visit;
    private static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        m = n;
        arr = new int[n];
        result = new int[n];
        visit = new boolean[n];

        for (int i = 0; i < n; i++) {
            arr[i] = i + 1;
        }
        func(0);
        System.out.println(sb.toString());
    }

    private static void func(int depth) {
        if (depth == m) {
            for (int val : result) {
                sb.append(val).append(" ");
            }
            sb.append("\n");
            return;
        }
        for (int i = 0; i < n; i++) {
            if (!visit[i]) {
                visit[i] = true;
                result[depth] = arr[i];
                func(depth + 1);
                visit[i] = false;
            }
        }
    }
}
