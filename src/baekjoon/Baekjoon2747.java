package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Baekjoon2747 {

    public static long[] d = new long[50];

    public static void main(String[] args) throws IOException {
        d[1] = 1;
        d[2] = 1;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println(fibo(Integer.parseInt(br.readLine())));
    }

    public static long fibo(int x) {
        for (int i = 3; i <= x; i++) {
            d[i] = d[i-1] + d[i-2];
        }
        return d[x];
    }
}
