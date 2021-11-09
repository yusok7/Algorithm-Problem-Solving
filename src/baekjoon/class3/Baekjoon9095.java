package baekjoon.class3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Baekjoon9095 {

    public static int[] d = new int[12];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        d[1] = 1;
        d[2] = 2;
        d[3] = 4;
        for (int i = 4; i <=10; i++) {
            d[i] = d[i-1] + d[i-2] + d[i-3];
        }
        for (int i = 0; i < n; i++) {
            int m = Integer.parseInt(br.readLine());
            System.out.println(d[m]);
        }
    }
}
