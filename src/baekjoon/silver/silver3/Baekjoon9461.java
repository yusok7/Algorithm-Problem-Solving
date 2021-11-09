package baekjoon.silver.silver3;

import java.io.*;

public class Baekjoon9461 {
    public static int[] d = new int[101];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        d[1] = d[2] = d[3] = 1;
        for (int i = 4; i <= 100; i++) {
            d[i] = d[i-3] + d[i-2];
        }

        int n = Integer.parseInt(br.readLine());
        for (int i = 0; i < n; i++) {
            int input = Integer.parseInt(br.readLine());
            bw.write(String.valueOf(d[input]));
            bw.write("\n");
        }
        bw.flush();
        bw.close();
    }
}
