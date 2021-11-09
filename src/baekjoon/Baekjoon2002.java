package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Baekjoon2002 {

    public static Map<String, Integer> in = new HashMap<>();
    public static Map<String, Integer> out = new HashMap<>();
    public static Set<String> set = new HashSet<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        for (int i = 0; i < n; i++) {
            String str = br.readLine();
            in.put(str, i);
        }

        for (int i = 0; i < n; i++) {
            String str = br.readLine();
            out.put(str, i);
        }

        set = in.keySet();

        int count = 0;
        for (String val : set) {
            if (in.get(val) > out.get(val)) {
                count++;
            }
        }
        System.out.println(count);
    }
}
