package baekjoon.silver.silver3;

import java.io.*;

public class Baekjoon1003 {

    public static long[] d0 = new long[41];
    public static long[] d1 = new long[41];

    public static void main(String[] args) throws IOException {

        d0[0] = 1;
        d0[1] = 0;
        d1[0] = 0;
        d1[1] = 1;

        for (int i = 2; i <= 40; i++) {
            d0[i] = d0[i-1] + d0[i-2];
            d1[i] = d1[i-1] + d1[i-2];
        }

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());

        for (int i = 0; i < n ; i++) {
            int input = Integer.parseInt(br.readLine());
            sb.append(d0[input]).append(" ").append(d1[input]).append("\n");
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}
