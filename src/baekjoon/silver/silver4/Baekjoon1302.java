package baekjoon.silver.silver4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Baekjoon1302 {

    public static Map<String, Integer> map = new HashMap<>();
    public static Set<String> set = new HashSet<>();
    public static List<Integer> list = new ArrayList<>();
    public static List<String> list2 = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        for (int i = 0; i < n; i++) {
            String name = br.readLine();
            map.put(name, map.getOrDefault(name, 0) + 1);
        }

        for (String name : map.keySet()) {
            Integer count = map.get(name);
            list.add(count);
        }
        int max = Collections.max(list);
        list.clear();

        for (String name : map.keySet()) {
            if (map.get(name) == max) {
                set.add(name);
            }
        }

        for (String s : set) {
            list2.add(s);
        }

        Collections.sort(list2);
        System.out.println(list2.get(0));
    }
}
