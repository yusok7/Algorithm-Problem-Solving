package baekjoon.silver.silver5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Baekjoon1789 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long n = Long.parseLong(br.readLine());

        long sum = 0l;
        long i = 1l;
        while (true) {
            sum += i;
            if (sum == n) {
                System.out.println(i);
                System.exit(0);
            }
            if (sum > n) {
                System.out.println(i - 1);
                System.exit(0);
            }
            i++;
        }
    }
}
