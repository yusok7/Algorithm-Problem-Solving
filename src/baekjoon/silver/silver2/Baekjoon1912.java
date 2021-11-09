package baekjoon.silver.silver2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Baekjoon1912 {
    public static int[] d;
    public static int[] arr;
    public static List<Integer> list = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        d = new int[n];
        arr = new int[n];

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        d[0] = arr[0];

        for (int i = 2; i <= n; i++) {
            d[i-1] = Math.max(arr[i-1], arr[i-1] + d[i-2]);
        }

        Arrays.sort(d);
        System.out.println(d[n-1]);
    }
}
