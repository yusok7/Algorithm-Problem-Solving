package baekjoon.silver.silver3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Baekjoon11047 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int answer = 0;

        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            int num = Integer.parseInt(br.readLine());
            list.add(num);
        }
        Collections.sort(list, Collections.reverseOrder());

        for (Integer val : list) {
            if (val > k)
                continue;
            else {
                answer += k / val;
                k = k % val;
            }
            if (k == 0)
                break;
        }
        System.out.println(answer);
    }
}
