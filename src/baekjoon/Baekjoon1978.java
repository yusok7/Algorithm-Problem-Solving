package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Baekjoon1978 {
    public static boolean prime[] = new boolean[1001];
    public static List<Integer> list = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int count = 0;
        setPrime();
        for (int i = 0; i < n; i++) {
            if (list.contains(Integer.parseInt(st.nextToken()))) count++;
        }
        System.out.println(count);
    }

    public static void setPrime() {
        int n = 1000;
        prime[0] = true;
        prime[1] = true;

        for (int i = 2; i*i <= n; i++) {
            if (prime[i] == false) {
                for (int j = i*i; j <=n; j+=i) {
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
