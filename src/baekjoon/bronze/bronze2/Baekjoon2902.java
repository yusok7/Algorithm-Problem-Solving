package baekjoon.bronze.bronze2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Baekjoon2902 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        char[] chars = br.readLine().toCharArray();
        for (char val : chars) {
            if (Character.isUpperCase(val))
                sb.append(val);
        }
        System.out.println(sb.toString());
    }
}
