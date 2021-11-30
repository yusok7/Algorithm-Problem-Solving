package baekjoon.gold.gold4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Baekjoon1351 {

    public static Map<Long, Long> map = new HashMap<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        long n = Long.parseLong(st.nextToken());
        long p = Long.parseLong(st.nextToken());
        long q = Long.parseLong(st.nextToken());

        map.put(0L, 1L);

        System.out.println(func(n, p, q));
    }

    public static long func(long x, long p, long q) {
        if (x == 0l) {
            return 1;
        }
        if (map.containsKey(x)) {
            return map.get(x);
        }
        map.put(x, func(x/p, p, q) + func(x/q, p, q));
        return map.get(x);
    }
}
