package baekjoon.silver.silver5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baekjoon1292 {

    public static StringBuilder sb = new StringBuilder();
    public static int[] d = new int[1001];
    public static int[] arr = new int[1001];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());

        d[0] = 0;
        arr[0] = 0;

        int count = 1;
        for (int i = 1; i <= 1000; i++) {
            for (int j = 0; j < i; j++) {
                arr[count] = i;
                count++;
                if (count == 1001) break;
            }
            if (count == 1001) break;
        }

        for (int i = 1; i <= 1000; i++) {
            d[i] = d[i - 1] + arr[i];
        }
        System.out.println(d[b] - d[a - 1]);
    }
}
