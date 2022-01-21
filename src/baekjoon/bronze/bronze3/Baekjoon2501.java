package baekjoon.bronze.bronze3;

import java.util.*;
import java.io.*;

public class Baekjoon2501 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        List<Integer> list = new ArrayList<>();

        for (int i = 1; i <= n; i++) {
            if (n % i == 0) {
                list.add(i);
            }
            if (list.size() == k) {
                System.out.println(list.get(k - 1));
                System.exit(0);
            }
        }
        System.out.println(0);
    }
}
