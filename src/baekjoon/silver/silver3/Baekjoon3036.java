package baekjoon.silver.silver3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baekjoon3036 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        int num = Integer.parseInt(st.nextToken());

        int[] arr = new int[n - 1];
        for (int i = 0; i < n - 1; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        for (int val : arr) {
            int gcd = euclid(num, val);
            int a = num / gcd;
            int b = val / gcd;
            System.out.println(a + "/" + b);
        }
    }

    private static int euclid(int n, int m) {
        if (m == 0)
            return n;
        return euclid(m, n % m);
    }
}
