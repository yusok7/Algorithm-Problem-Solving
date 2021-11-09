package baekjoon.class2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Baekjoon1929 {

    public static boolean[] prime = new boolean[1000001];
    public static List<Integer> list = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        isPrime();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int m = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());
        while (true) {
            for (Integer val : list) {
                if (val >= m && val <= n) {
                    System.out.println(val);
                }
                if (val > n) break;
            }
            break;
        }
    }

    public static void isPrime() {
        int n = 1000000;
        prime[0] = prime[1] = true;

        for (int i = 2; i*i <= n; i++) {
            if (!prime[i]) {
                for (int j = i*i; j <= n; j+=i) {
                    prime[j] = true;
                }
            }
        }

        for (int j = 0; j <= n; j++) {
            if (prime[j] == false) {
                list.add(j);
            }
        }
    }
}
