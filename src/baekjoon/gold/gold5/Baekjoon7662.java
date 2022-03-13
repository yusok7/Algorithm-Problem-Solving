package baekjoon.gold.gold5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Baekjoon7662 {

    private static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testCase = Integer.parseInt(br.readLine());

        for (int t = 0; t < testCase; t++) {
            TreeMap<Integer, Integer> map = new TreeMap<>();
            int n = Integer.parseInt(br.readLine());
            for (int i = 0; i < n; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                String str1 = st.nextToken();
                String str2 = st.nextToken();
                if (str1.equals("I")) {
                    int num = Integer.parseInt(str2);
                    map.put(num, map.getOrDefault(num, 0 ) + 1);
                    continue;
                } else if (str1.equals("D")) {
                    if (map.isEmpty())
                        continue;

                    if (str2.equals("-1")) {
                        Integer key = map.firstKey();
                        if (map.get(key) == 1) {
                            map.remove(key);
                            continue;
                        } else {
                            map.put(key, map.get(key) - 1);
                            continue;
                        }
                    } else if (str2.equals("1")) {
                        Integer key = map.lastKey();
                        if (map.get(key) == 1) {
                            map.remove(key);
                            continue;
                        } else {
                            map.put(key, map.get(key) - 1);
                            continue;
                        }
                    }
                }
            }
            if (map.isEmpty())
                sb.append("EMPTY");
            else {
                sb.append(map.lastKey()).append(" ").append(map.firstKey());
            }
            sb.append("\n");
        }
        System.out.println(sb.toString());
    }
}
