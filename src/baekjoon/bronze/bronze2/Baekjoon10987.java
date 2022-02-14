package baekjoon.bronze.bronze2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Baekjoon10987 {

    private static Map<Character, Integer> map = new HashMap<>();

    public static void main(String[] args) throws IOException {
        func();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int answer = 0;
        for (char c : br.readLine().toCharArray()) {
            if (map.containsKey(c))
                answer++;
        }
        System.out.println(answer);
    }

    private static void func() {
        char[] arr = new char[] {'a', 'e', 'i', 'o', 'u'};
        for (int i = 0; i < arr.length; i++)
            map.put(arr[i], 0);
    }
}
