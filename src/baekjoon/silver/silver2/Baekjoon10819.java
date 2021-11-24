package baekjoon.silver.silver2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Baekjoon10819 {

    public static int[] per;
    public static boolean[] visit;
    public static int[] arr;
    public static int n;
    public static int m;
    public static List<Integer> list = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        m = n;
        arr = new int[n];
        visit = new boolean[n];
        per = new int[m];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        dfs(0);
        Collections.sort(list);
        System.out.println(Collections.max(list));
    }

    public static void dfs(int depth) {
        if (depth == m) {
            int[] output = new int[m];
            for (int i = 0; i < m; i++) {
                output[i] = arr[per[i]];
            }
            func(output);
            return;
        }
        for (int i = 0; i < n; i++) {
            if (!visit[i]) {
                visit[i] = true;
                per[depth] = i;
                dfs(depth + 1);
                visit[i] = false;
            }
        }
    }

    public static void func(int[] arr) {
        int sum = 0;
        for (int i = 0; i < arr.length - 1; i++) {
            sum += Math.abs(arr[i] - arr[i+1]);
        }
        list.add(sum);
    }

}
