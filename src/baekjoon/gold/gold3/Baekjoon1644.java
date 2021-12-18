package baekjoon.gold.gold3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Baekjoon1644 {

    public static boolean[] prime = new boolean[5000001];
    public static List<Integer> list = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        isPrime();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        if (n == 2) {
            System.out.println(1);
            System.exit(0);
        }

        int start = 0;
        int end = 1;
        int sum = 5;
        int result = 0;
        while (true) {
            if (start == end) {
                sum = list.get(start);
            }

            if (sum == n) {
                result++;
                sum = sum - list.get(start);
                start++;
            } else if (sum < n) {
                end++;
                sum = sum + list.get(end);
            } else if (sum > n) {
                sum = sum - list.get(start);
                start++;
            }

            if (list.get(start) > n) {
                break;
            }
        }
        System.out.println(result);
    }

    public static void isPrime() {
        int n = 5000000;
        prime[0] = prime[1] = true;

        for (int i = 2; i * i <= n; i++) {
            if (!prime[i]) {
                for (int j = i * i; j <= n; j += i) {
                    prime[j] = true;
                }
            }
        }

        for (int i = 2; i <= n; i++) {
            if (!prime[i]) {
                list.add(i);
            }
        }

    }
}
