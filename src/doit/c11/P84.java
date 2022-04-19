package doit.c11;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P84 {

    private static int[] d;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        d = new int[1000001];

        d[0] = d[1] = 0;
        d[2] = 1;

        if (n <= 2) {
            System.out.println(d[n]);
            System.exit(0);
        }

        for (int i = 3; i <= n; i++) {
            d[i] = d[i - 1] + 1;
            if (i % 2 == 0)
                d[i] = Math.min(d[i / 2] + 1, d[i]);
            if (i % 3 == 0)
                d[i] = Math.min(d[i / 3] + 1, d[i]);
        }
        System.out.println(d[n]);
    }
}
