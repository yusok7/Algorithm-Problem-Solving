package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.StringTokenizer;

public class Baekjoon3009 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Map<Integer, Integer> map1 = new HashMap<>();
        Map<Integer, Integer> map2 = new HashMap<>();

        for (int i = 0; i < 3; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());
            map1.put(n,map1.getOrDefault(n,0) + 1);
            map2.put(m,map2.getOrDefault(m,0) + 1);
        }

        Set<Integer> integer1 = map1.keySet();
        Set<Integer> integer2 = map2.keySet();

        StringBuilder sb = new StringBuilder();
        for (Integer val : integer1) {
            if (map1.get(val) == 1) {
                sb.append(val+" ");
            }
        }
        for (Integer val : integer2) {
            if (map2.get(val) == 1) {
                sb.append(val);
            }
        }
        System.out.println(sb.toString());
    }
}
