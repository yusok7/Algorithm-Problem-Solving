package baekjoon.gold.gold5;

import java.util.*;
import java.io.*;

public class Baekjoon1107_2 {

    private static int target, n, min;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        target = Integer.parseInt(br.readLine());
        n = Integer.parseInt(br.readLine());

        if (n == 0) {
            int answer = Math.min(Math.abs(100 - target), String.valueOf(target).length());
            System.out.println(answer);
            System.exit(0);
        }

        boolean[] broken = new boolean[10];
        StringTokenizer st = new StringTokenizer(br.readLine());
        while (st.hasMoreTokens()) {
            int num = Integer.parseInt(st.nextToken());
            broken[num] = true;
        }

        if (target == 100) {
            System.out.println(0);
            System.exit(0);
        }

        min = Math.abs(target - 100);

        for (int t = 0; t <= 999999; t++) {
            String str = String.valueOf(t);
            int length = str.length();
            boolean bool = false;

            for (int i = 0; i < str.length(); i++) {
                int idx = str.charAt(i) - '0';
                if (broken[idx]) {
                    bool = true;
                    break;
                }
            }

            if (bool)
                continue;

            int sum = length + Math.abs(target - t);
            min = Math.min(sum, min);
        }
        System.out.println(min);
    }
}
