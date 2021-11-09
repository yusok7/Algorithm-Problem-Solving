package baekjoon.class3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Baekjoon1764 {
    public static Map<String, Integer> map1 = new HashMap<>();
    public static Map<String, Integer> map2 = new HashMap<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        for (int i = 0; i < n; i++) {
            String str = br.readLine();
            map1.put(str, i);
        }

        for (int i = 0; i < m; i++) {
            String str = br.readLine();
            map2.put(str, i);
        }

        Set<String> set = map1.keySet();
        List<String> list = new ArrayList<>();
        // 모든 키값에 대하여
        for (String val : set) {
            if (map2.containsKey(val)) {
                list.add(val);
            }
        }

        System.out.println(list.size());
        Collections.sort(list);
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }
    }
}
