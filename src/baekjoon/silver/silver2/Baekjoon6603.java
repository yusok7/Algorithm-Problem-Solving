package baekjoon.silver.silver2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baekjoon6603 {
    public static int[] comb;
    public static int[] arr;
    public static int n;
    public static int m;
    public static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        m = 6;
        comb = new int[m];

        while (true) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
            if (n == 0) break;
            arr = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
            }
            dfs(0, 0);
            sb.append("\n");
        }
        System.out.println(sb.toString());
    }

    public static void dfs(int at, int depth) {
        if (depth == m) {
            for (int i = 0; i < m; i++) {
                if (i == m-1) {
                    sb.append(arr[comb[i]]).append("\n");
                } else {
                    sb.append(arr[comb[i]]).append(" ");
                }
            }
            return;
        }
        for (int i = at; i < n; i++) {
            comb[depth] = i;
            dfs(i+1, depth+1);
        }
    }

}
