package baekjoon.silver.silver3.nm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Baekjoon15666 {

    private static int n, m;
    private static int[] arr;
    private static int[] result;
    private static Set<String> set = new LinkedHashSet<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        arr = new int[n];
        result = new int[m];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);

        func(0, 0);
        for (String s : set) {
            System.out.println(s);
        }
    }

    private static void func(int start, int depth) {
        if (depth == m) {
            StringBuilder sb = new StringBuilder();
            for (int val : result) {
                sb.append(val).append(" ");
            }
            set.add(sb.toString());
            return;
        }
        for (int i = start; i < n; i++) {
            result[depth] = arr[i];
            func(i, depth + 1);
        }
    }
}
