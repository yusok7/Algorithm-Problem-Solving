package baekjoon.silver.silver4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.TreeMap;

public class Baekjoon1822 {

    private static TreeMap<Integer, Integer> map1 = new TreeMap<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++)
            map1.put(Integer.parseInt(st.nextToken()), 0);

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < m; i++) {
            int num = Integer.parseInt(st.nextToken());
            if (map1.containsKey(num))
                map1.remove(num);
        }

        if (map1.isEmpty()) {
            System.out.println(0);
            System.exit(0);
        }

        StringBuilder sb = new StringBuilder();
        for (Integer key : map1.keySet()) {
            sb.append(key).append(" ");
        }
        System.out.println(map1.size());
        System.out.println(sb.toString());
    }
}
