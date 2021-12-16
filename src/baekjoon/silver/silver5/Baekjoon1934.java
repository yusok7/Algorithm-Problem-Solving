package baekjoon.silver.silver5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baekjoon1934 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int input1 = Integer.parseInt(st.nextToken());
            int input2 = Integer.parseInt(st.nextToken());
            int val1 = Math.max(input1, input2);
            int val2 = Math.min(input1, input2);
            int val = func(val1, val2);
            System.out.println(input1 * input2 / val);
        }
    }

    public static int func(int n, int m) {
        int r = n % m;
        if (r == 0) {
            return m;
        } else {
            return func(m, r);
        }
    }
}
