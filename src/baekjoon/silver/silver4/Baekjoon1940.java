package baekjoon.silver.silver4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Baekjoon1940 {

    public static Map<Integer, Integer> map = new HashMap<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 0; i < n; i++) {
            map.put(Integer.parseInt(st.nextToken()), 1);
        }

        int count = 0;
        for (int val : map.keySet()) {
            int x = val;
            int y = m - val;
            if (map.get(x) == 1 && map.containsKey(y) && map.get(y) == 1 && x != y) {
                count++;
                map.put(x, 0);
                map.put(y, 0);
            }
        }

        System.out.println(count);
    }
}
