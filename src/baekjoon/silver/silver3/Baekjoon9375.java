package baekjoon.silver.silver3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Baekjoon9375 {

    public static Map<String, Integer> map = new HashMap<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        for (int i = 0; i < n; i++) {
            map.clear();
            int m = Integer.parseInt(br.readLine());
            for (int j = 0; j < m; j++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                st.nextToken();
                String str = st.nextToken();
                map.put(str, map.getOrDefault(str, 1) + 1);
            }
            int answer = 1;
            for (String key : map.keySet()) {
                answer *= map.get(key);
            }
            System.out.println(answer - 1);
        }
    }
}
