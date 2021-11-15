package baekjoon.silver.silver4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Baekjoon11653 {

    public static boolean[] prime = new boolean[10000001];
    public static List<Integer> list = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        isPrime();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        while (true) {
            for (int i = 0; i <= n; i++) {
                if (n % list.get(i) == 0) {
                    sb.append(list.get(i)).append("\n");
                    n = n / list.get(i);
                    break;
                }
            }
            if (n == 1) break;
        }
        System.out.println(sb.toString());
    }

    public static void isPrime() {
        int n = 10000000;
        prime[0] = prime[1] = true;
        for (int i = 2; i*i <= n; i++) {
            if (!prime[i]) {
                for (int j = i*i; j <= n; j += i) {
                    prime[j] = true;
                }
            }
        }
        for (int i = 0; i <=n ; i++) {
            if (!prime[i]) {
                list.add(i);
            }
        }
    }
}
