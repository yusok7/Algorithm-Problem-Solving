package baekjoon.silver.silver5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Baekjoon7785 {

    public static Map<String, Integer> map = new HashMap<>();
    public static List<String> list = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String name = st.nextToken();
            String state = st.nextToken();
            if (state.equals("enter")) {
                map.put(name, i);
            } else {
                map.remove(name);
            }
        }

        for (String name : map.keySet()) {
            list.add(name);
        }

        Collections.sort(list, Collections.reverseOrder());

        for (String name : list) {
            System.out.println(name);
        }

    }
}
