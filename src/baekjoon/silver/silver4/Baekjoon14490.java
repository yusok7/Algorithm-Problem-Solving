package baekjoon.silver.silver4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baekjoon14490 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), ":");
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int gcd = gcd(n, m);
        n = n / gcd;
        m = m / gcd;
        System.out.println(n + ":" + m);
    }

    private static int gcd(int n, int m) {
        if (m == 0)
            return n;
        return gcd(m, n % m);
    }
}
