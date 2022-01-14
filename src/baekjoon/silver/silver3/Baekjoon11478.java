package baekjoon.silver.silver3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Baekjoon11478 {

    public static Map<String, Integer> map = new HashMap<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();

        int index = 1;
        while (true) {
            for (int i = 0; i < str.length(); i++) {
                if (i + index > str.length()) break;
                map.put(str.substring(i, i + index), 0);
            }
            index++;
            if (index > str.length()) {
                break;
            }
        }
        System.out.println(map.size());
    }
}
