package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Baekjoon2581 {
    public static boolean[] prime = new boolean[10001];
    public static List<Integer> numbers = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        isPrime();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int m = Integer.parseInt(br.readLine());
        int n = Integer.parseInt(br.readLine());

        int sum = 0;
        List<Integer> result = new ArrayList<>();
        for (int i = m; i <= n; i++) {
            if (numbers.contains(i)) {
                sum += i;
                result.add(i);
            }
        }

        if (result.size() == 0) {
            System.out.println(-1);
            System.exit(0);
        }

        System.out.println(sum);
        System.out.println(Collections.min(result));
    }

    public static void isPrime() {
        int n = 10000;
        prime[0] = prime[1] = true;
        for (int i = 2; i*i <= n; i++) {
            if (!prime[i]) {
                for (int j = i*i; j <= n; j+= i) {
                    prime[j] = true;
                }
            }
        }

        for (int i = 0; i <= n; i++) {
            if (!prime[i]) {
                numbers.add(i);
            }
        }
    }
}
