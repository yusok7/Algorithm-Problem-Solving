package baekjoon.class3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Baekjoon1620 {

    public static Map<String, Integer> map = new HashMap<>();
    public static List<String> list = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        for (int i = 0; i < n; i++) {
            String str = br.readLine();
            map.put(str, i+1);
            list.add(str);
        }

        for (int i = 0; i < m; i++) {
            String str = br.readLine();
            char c = str.charAt(0);
            if (Character.isDigit(c)) {
                int number = Integer.parseInt(str);
                System.out.println(list.get(number-1));
            } else {
                System.out.println(map.get(str));
            }
        }
    }
}
