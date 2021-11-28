package baekjoon.silver.silver4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Baekjoon11652 {

    public static Map<Long,Long> map = new HashMap<>();
    public static List<Long> list = new ArrayList<>();
    public static List<Long> result = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long n = Long.parseLong(br.readLine());

        for (long i = 0; i < n; i++) {
            long input = Long.parseLong(br.readLine());
            map.put(input, map.getOrDefault(input, 0l) +1);
        }

        Set<Long> keys = map.keySet();

        for (Long val : keys) {
            list.add(map.get(val));
        }

        long max = Collections.max(list);

        for (Long val : keys) {
            if (map.get(val) == max) {
                result.add(val);
            }
        }

        System.out.println(Collections.min(result));
    }
}
