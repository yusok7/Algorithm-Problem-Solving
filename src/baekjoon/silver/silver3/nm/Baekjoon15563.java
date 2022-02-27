package baekjoon.silver.silver3.nm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.StringTokenizer;

public class Baekjoon15563 {

    private static int n, m;
    private static int[] arr;
    private static int[] per;
    private static boolean[] visit;
    private static LinkedHashSet<String> set;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        arr = new int[n];
        per = new int[m];
        visit = new boolean[n];
        set = new LinkedHashSet<>();

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);
        dfs(0);
        set.forEach(System.out::println);
    }

    private static void dfs(int depth) {
        if (depth == m) {
            StringBuilder sb = new StringBuilder();
            for (int val : per) {
                sb.append(val).append(" ");
            }
            set.add(sb.toString());
            return;
        }

        for (int i = 0; i < n; i++) {
            if (!visit[i]) {
                visit[i] = true;
                per[depth] = arr[i];
                dfs(depth + 1);
                visit[i] = false;
            }
        }
    }
}
