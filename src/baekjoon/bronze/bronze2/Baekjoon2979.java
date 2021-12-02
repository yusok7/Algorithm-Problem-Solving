package baekjoon.bronze.bronze2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baekjoon2979 {

    public static int[] arr = new int[101];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());

        for (int i = 0; i < 3; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int last = Integer.parseInt(st.nextToken());
            for (int j = start; j < last; j++) {
                arr[j] += 1;
            }
        }

        int sum = 0;
        for (int val : arr) {
            if (val == 0) continue;
            if (val == 1) sum += (a * 1);
            if (val == 2) sum += (b * 2);
            if (val == 3) sum += (c * 3);
        }
        System.out.println(sum);
    }
}
