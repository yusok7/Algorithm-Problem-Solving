package baekjoon.silver.silver2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Baekjoon11047 {

    public static List<Integer> list = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        for (int i = 0; i < n; i++) {
            int input = Integer.parseInt(br.readLine());
            list.add(input);
        }

        Collections.sort(list, Collections.reverseOrder());

        int result = 0;

        for (Integer val : list) {
            if (val > k) continue;
            else {
                result += k / val;
                k = k % val;
            }

            if (k == 0) break;
        }

        System.out.println(result);
    }
}
