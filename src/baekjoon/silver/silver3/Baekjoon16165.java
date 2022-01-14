package baekjoon.silver.silver3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Baekjoon16165 {

    public static Map<String, String> map = new HashMap<>();
    public static List<String> list = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        for (int i = 0; i < n; i++) {
            String teamName = br.readLine();
            int num = Integer.parseInt(br.readLine());
            for (int j = 0; j < num; j++) {
                String name = br.readLine();
                map.put(name, teamName);
            }
        }

        for (int i = 0; i < m; i++) {
            list.clear();
            String name = br.readLine(); // 팀 이름 혹은 멤버 이름
            int num = Integer.parseInt(br.readLine()); // 0 혹은 1

            if (num == 1) {
                System.out.println(map.get(name));
            } else if (num == 0) {
                for (String val : map.keySet()) {
                    if (map.get(val).equals(name)) {
                        list.add(val);
                    }
                }
                Collections.sort(list);
                for (String val : list) {
                    System.out.println(val);
                }
            }
        }
    }
}
