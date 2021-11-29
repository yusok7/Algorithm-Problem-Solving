package baekjoon.silver.silver1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Baekjoon6588 {

    public static boolean[] prime = new boolean[1000001];
    public static Map<Integer, Integer> map = new HashMap<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        isPrime();
        while (true) {
            int n = Integer.parseInt(br.readLine());
            if (n == 0) break;
            for (int i = 0; i < 1000001; i++) {
                if (!prime[i]) {
                    int m = n - i;
                    if (map.containsKey(m)) {
                        System.out.println(n + " = " + i + " + " + m);
                        break;
                    }
                }
                if (i >= n) {
                    System.out.println("Goldbach's conjecture is wrong.");
                    break;
                }
            }
        }
    }

    public static void isPrime() {
        int n = 1000000;
        prime[0] = prime[1] = true;
        for (int i = 2; i * i <= n; i++) {
            if (!prime[i]) {
                for (int j = i * i; j <= n; j += i) {
                    prime[j] = true;
                }
            }
        }

        for (int i = 0; i <= n; i++) {
            if (!prime[i]) {
                map.put(i, i);
            }
        }

    }
}
