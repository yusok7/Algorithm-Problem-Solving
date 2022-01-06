package baekjoon.silver.silver4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Baekjoon5648 {

    public static List<Long> list = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long n = 0;

        while (true) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            if (n == 0) {
                n = Long.parseLong(st.nextToken());
            }
            while (st.hasMoreTokens()) {
                StringBuilder sb = new StringBuilder();
                sb.append(st.nextToken()).reverse();
                long num = Long.parseLong(sb.toString());
                list.add(num);
            }
            if (list.size() == n) break;
        }
        Collections.sort(list);
        for (Long val : list) {
            System.out.println(val);
        }

    }
}
