package baekjoon.silver.silver1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Baekjoon2156 {

    public static int[] d;
    public static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        d = new int[n+1];
        arr = new int[n+1];

        for (int i = 1; i <= n; i++) {
            int num = Integer.parseInt(br.readLine());
            arr[i] = num;
        }

        d[1] = arr[1];
        d[2] = arr[1] + arr[2];

        for (int i = 3; i <= n; i++) {
            d[i] = Math.max(arr[i] + d[i-2], arr[i] + arr[i-1] + d[i-3]);
        }

        Arrays.sort(d);
        System.out.println(d[n]);
    }
}
