package baekjoon.bronze.bronze3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Baekjoon2754 {

    private static Double[] arr = {4.3, 4.0, 3.7};
    private static String[] arr1 = {"A", "B", "C", "D"};
    private static String[] arr2 = {"+", "0", "-"};
    private static Map<String, Double> map = new HashMap<>();

    public static void main(String[] args) throws IOException {
        func();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        Double score = str.equals("F") ? 0.0 : map.get(str);
        System.out.println(String.format("%.1f", score));
    }

    private static void func() {
        for (int i = 0; i < arr1.length; i++) {
            for (int j = 0; j < arr2.length; j++) {
                Double sub = i * 1.0;
                String str = arr1[i] + arr2[j];
                Double num = arr[j] - sub;
                map.put(str, num);
            }
        }
    }
}
