package baekjoon.bronze.bronze3;

import java.util.*;
import java.io.*;

public class Baekjoon20361 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int x = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int[] arr = new int[n + 1];
        arr[x] = 1;

        for (int i = 0; i < k; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int change = arr[a];
            arr[a] = arr[b];
            arr[b] = change;
        }

        for (int i = 1; i <= n; i++) {
            if (arr[i] == 1)
                System.out.println(i);
        }
    }
}
