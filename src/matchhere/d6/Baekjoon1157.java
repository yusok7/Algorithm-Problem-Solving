package matchhere.d6;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Baekjoon1157 {

    public static Map<String, Integer> map = new HashMap<>();
    public static List<Integer> list = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine().toLowerCase(Locale.ROOT);
        String[] strArr = str.split("");

        for (String val : strArr) {
            map.put(val, map.getOrDefault(val, 0) + 1);
        }

        for (String val : map.keySet()) {
            list.add(map.get(val));
        }

        int maxCount = Collections.max(list);
        int count = 0;
        for (Integer val : list) {
            if (val == maxCount) count++;
        }

        if (count != 1) System.out.println("?");
        else {
            for (String val : map.keySet()) {
                if (map.get(val) == maxCount) {
                    System.out.println(val.toUpperCase(Locale.ROOT));
                }
            }
        }
    }
}
