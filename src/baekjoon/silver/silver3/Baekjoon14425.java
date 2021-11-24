package baekjoon.silver.silver3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Baekjoon14425 {
    public static Map<String, Integer> map = new HashMap<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        for (int i = 0; i < n; i++) {
            String str = br.readLine();
            map.put(str,i);
        }
        int count = 0;
        for (int i = 0; i < m; i++) {
            String str = br.readLine();
            if (map.containsKey(str)) count++;
        }
        System.out.println(count);
    }
}
