package baekjoon.silver.silver3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Baekjoon7795 {

    private static List<Integer> list1 = new ArrayList<>();
    private static List<Integer> list2 = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        for (int i = 0; i < t; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                list1.add(Integer.parseInt(st.nextToken()));
            }
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                list2.add(Integer.parseInt(st.nextToken()));
            }

            Collections.sort(list1);
            Collections.sort(list2, Collections.reverseOrder());

            int result = 0;
            for (Integer val : list1) {
                for (int j = 0; j < list2.size(); j++) {
                    if (val > list2.get(j)) {
                        result += list2.size() - j;
                        break;
                    }
                }
            }
            System.out.println(result);
            list1.clear();
            list2.clear();
        }
    }
}
