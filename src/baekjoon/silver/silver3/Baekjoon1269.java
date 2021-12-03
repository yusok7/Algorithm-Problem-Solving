package baekjoon.silver.silver3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Baekjoon1269 {

    public static Map<Integer, Integer> map1 = new HashMap<>();
    public static Map<Integer, Integer> map2 = new HashMap<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            map1.put(Integer.parseInt(st.nextToken()), i);
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < m; i++) {
            map2.put(Integer.parseInt(st.nextToken()), i);
        }

        int count1 = 0;
        int count2 = 0;

        for (Integer key : map1.keySet()) {
            if (!map2.containsKey(key)) {
                count1++;
            }
        }

        for (Integer key : map2.keySet()) {
            if (!map1.containsKey(key)) {
                count2++;
            }
        }

        System.out.println(count1 + count2);
    }
}
