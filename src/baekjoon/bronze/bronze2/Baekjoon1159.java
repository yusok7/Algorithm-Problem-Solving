package baekjoon.bronze.bronze2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Baekjoon1159 {

    public static Map<String, Integer> map = new HashMap<>();
    public static List<String> list = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        for (int i = 0; i < n; i++) {
            String str = br.readLine();
            char c = str.charAt(0);
            String key = String.valueOf(c);
            map.put(key, map.getOrDefault(key, 0) + 1);
        }

        for (String key : map.keySet()) {
            Integer val = map.get(key);
            if (val >= 5) {
                list.add(key);
            }
        }

        if (list.size() == 0) {
            System.out.println("PREDAJA");
            System.exit(0);
        }

        Collections.sort(list);
        StringBuilder sb = new StringBuilder();
        for (String s : list) {
            sb.append(s);
        }
        System.out.println(sb.toString());
    }
}
