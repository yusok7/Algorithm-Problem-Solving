package baekjoon.silver.silver2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Baekjoon4948 {

    public static boolean[] prime = new boolean[246913];
    public static Map<Integer, Integer> map = new HashMap<>();

    public static void main(String[] args) throws IOException {
        isPrime();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        while (true) {
            int start = Integer.parseInt(br.readLine());
            int end = start * 2;

            if (start == 0) break;

            int count = 0;
            for (int i = start+1; i <= end; i++) {
                if (map.containsKey(i)) count++;
            }
            sb.append(count).append("\n");
        }
        System.out.println(sb.toString());
    }

    public static void isPrime() {

        int n = 246912;
        prime[0] = prime[1] = true;
        for (int i = 2; i*i <= n; i++) {
            if (!prime[i]) {
                for (int j = i*i; j <= n; j += i) {
                    prime[j] = true;
                }
            }
        }

        for (int i = 0; i <= 246912; i++) {
            if (!prime[i]) {
                map.put(i, i);
            }
        }
    }
}
