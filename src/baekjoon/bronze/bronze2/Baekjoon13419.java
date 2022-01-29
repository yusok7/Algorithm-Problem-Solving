package baekjoon.bronze.bronze2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Baekjoon13419 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        for (int i = 0; i < n; i++) {
            String str = br.readLine();
            if (str.length() == 1) {
                System.out.println(str);
                System.out.println(str);
                continue;
            }

            if (str.length() % 2 == 0) {
                String first = first(str);
                String second = second(str);
                System.out.println(first);
                System.out.println(second);
            } else if (str.length() % 2 == 1) {
                str = str + str;
                String first = first(str);
                String second = second(str);
                System.out.println(first);
                System.out.println(second);
            }
        }
    }

    private static String first(String str) {
        String first = "";
        for (int j = 0; j < str.length(); j += 2) {
            first += str.charAt(j);
        }
        return first;
    }

    private static String second(String str) {
        String second = "";
        for (int j = 1; j < str.length(); j += 2) {
            second += str.charAt(j);
        }
        return second;
    }
}
