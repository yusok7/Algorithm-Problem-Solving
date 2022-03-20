package baekjoon.bronze.bronze1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Baekjoon1977 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int m = Integer.parseInt(br.readLine());
        int n = Integer.parseInt(br.readLine());

        double sqrt = Math.sqrt(m);
        int start = (int) Math.ceil(sqrt);
        int end = (int) Math.sqrt(n);

        if (start > end) {
            System.out.println(-1);
        } else {
            int sum = 0;
            for (int i = start; i <= end; i++) {
                sum += i * i;
            }
            System.out.println(sum);
            System.out.println(start * start);
        }
    }
}
