package baekjoon.class2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Baekjoon2839 {

    public static int[] d = new int[5001];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        if (n == 4 || n == 7) {
            System.out.println(-1);
            System.exit(0);
        }

        d[3] = 1;
        d[11] = 3;
        d[12] = d[14] = d[16] = 4;
        d[17] = d[19] = 5;

        for (int i = 4; i <= 20; i++) {
            int count = 0;
            int index = i;
            if (i % 5 == 0) {
                d[i] = i / 5;
                continue;
            }

            if (i % 5 != 0) {
                count = i / 5;
                i = i % 5;
                if (i % 3 == 0) {
                    d[index] = count + i / 3;
                    i = index;
                    continue;
                }
                i = index;
            }

            if (i % 3 == 0) {
                d[i] = i / 3;
            }
        }

        if (d[n] != 0) {
            System.out.println(d[n]);
        } else {
            int x = n / 10 - 1;
            if (x == 0) x = 1;
            int y = n - 10 * x;
            int result = x * 2 + d[y];
            System.out.println(result);
        }
    }
}
