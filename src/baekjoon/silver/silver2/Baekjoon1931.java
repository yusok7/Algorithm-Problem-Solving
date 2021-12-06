package baekjoon.silver.silver2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Baekjoon1931 {

    public static int[][] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        arr = new int[n][2];

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            arr[i][0] = Integer.parseInt(st.nextToken());
            arr[i][1] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr, (int[] a1, int[] a2) -> {
            if (a1[1] == a2[1]) {
                return a1[0] - a2[0];
            } else {
                return a1[1] - a2[1];
            }
        });

        int count = 0;
        int end = 0;

        for (int[] val : arr) {
            if (val[0] >= end) {
                end = val[1];
                count++;
            }
        }

        System.out.println(count);
    }
}
