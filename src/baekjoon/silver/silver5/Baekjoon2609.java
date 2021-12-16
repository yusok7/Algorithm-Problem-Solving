package baekjoon.silver.silver5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baekjoon2609 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int input1 = Integer.parseInt(st.nextToken());
        int input2 = Integer.parseInt(st.nextToken());

        int n = Math.max(input1, input2);
        int m = Math.min(input1, input2);

        int result1 = func(n, m);
        int result2 = n * m / result1;

        System.out.println(result1);
        System.out.println(result2);
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
