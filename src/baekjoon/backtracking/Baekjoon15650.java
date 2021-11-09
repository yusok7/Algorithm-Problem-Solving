package baekjoon.backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baekjoon15650 {

    public static int n = 0;
    public static int m = 0;
    public static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        arr = new int[m];

        dfs(0, 0);

    }

    public static void dfs(int at, int depth) {
        if (depth == m) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < arr.length; i++) {
                sb.append(arr[i] + " ");
            }
            System.out.println(sb.toString());
            return;
        }
        for (int i = at; i < n; i++) {
            arr[depth] = i + 1;
            dfs(i + 1, depth + 1);
        }
    }
}
