package baekjoon.bronze.bronze2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Baekjoon1264 {

    private static Map<Character, Integer> map = new HashMap<>();

    public static void main(String[] args) throws IOException {
        func();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = "";

        while (true) {
            int answer = 0;
            str = br.readLine().toLowerCase();
            if (str.equals("#")) break;
            for (char c : str.toCharArray()) {
                if (map.containsKey(c))
                    answer++;
            }
            System.out.println(answer);
        }
    }

    private static void func() {
        String str = "aeiou";
        for (char c : str.toCharArray()) {
            map.put(c, 0);
        }
    }
}
