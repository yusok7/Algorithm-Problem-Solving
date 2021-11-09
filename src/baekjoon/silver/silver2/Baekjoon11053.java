package baekjoon.silver.silver2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Baekjoon11053 {

    public static int[] d;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        d = new int[n];
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);
        d[0] = arr[0];

        int count = 0;
        for (int i = 1; i < n; i++) {
            if (arr[i] > d[i-1]) {
                d[i] = arr[i];
                count++;
            } else {
                d[i] = d[i-1];
            }
        }
        System.out.println(count+1);
    }
}
