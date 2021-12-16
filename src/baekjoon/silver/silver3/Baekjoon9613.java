package baekjoon.silver.silver3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Baekjoon9613 {

    public static List<Integer> list = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        for (int i = 0; i < n; i++) {
            list.clear();
            long sum = 0;
            StringTokenizer st = new StringTokenizer(br.readLine());
            st.nextToken();
            while (st.hasMoreTokens()) {
                list.add(Integer.parseInt(st.nextToken()));
            }
            for (int j = 0; j < list.size() - 1; j++) {
                for (int k = j + 1; k < list.size(); k++) {
                    sum += func(Math.max(list.get(j), list.get(k)), Math.min(list.get(j), list.get(k)));
                }
            }
            System.out.println(sum);

        }

    }

    public static int func(int n, int m) {
        int r = n % m;
        if (r == 0) {
            return m;
        } else {
            return func(m, r);
        }
    }
}
