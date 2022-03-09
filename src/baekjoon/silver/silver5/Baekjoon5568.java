package baekjoon.silver.silver5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Baekjoon5568 {

    private static Map<Integer, Integer> map = new HashMap<>();
    private static int[] arr;
    private static int[] per;
    private static boolean[] visit;
    private static int n;
    private static int k;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        k = Integer.parseInt(br.readLine());

        arr = new int[n];
        per = new int[k];
        visit = new boolean[n];

        for (int i = 0; i < n; i++)
            arr[i] = Integer.parseInt(br.readLine());
        func(0);
        System.out.println(map.size());
    }

    private static void func(int depth) {
        if (depth == k) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < per.length; i++) {
                sb.append(per[i]);
            }
            map.put(Integer.parseInt(sb.toString()), 0);
            return;
        }

        for (int i = 0; i < n; i++) {
            if (!visit[i]) {
                visit[i] = true;
                per[depth] = arr[i];
                func(depth + 1);
                visit[i] = false;
            }
        }
    }
}
