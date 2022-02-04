package baekjoon.bronze.bronze2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Baekjoon10812 {

    public static void main(String[] args) throws IOException {
        List<Integer> list = new ArrayList<>();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[] arr = new int[n + 1];

        for (int i = 1; i <= n; i++) {
            arr[i] = i;
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int mid = Integer.parseInt(st.nextToken());

            for (int j = mid; j <= end; j++) {
                list.add(arr[j]);
            }
            for (int j = start; j <= mid - 1; j++) {
                list.add(arr[j]);
            }

            int index = 0;
            for (int j = start; j <= end; j++) {
                arr[j] = list.get(index++);
            }

            list.clear();
        }

        StringBuilder sb = new StringBuilder();
        for (int val : arr) {
            if (val == 0) continue;
            sb.append(val).append(" ");
        }
        System.out.println(sb.toString());
    }
}
