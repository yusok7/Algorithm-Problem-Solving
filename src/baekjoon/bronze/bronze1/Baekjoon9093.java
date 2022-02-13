package baekjoon.bronze.bronze1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Baekjoon9093 {

    public static void main(String[] args) throws IOException {
        List<String> list = new ArrayList<>();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        StringBuilder sb2 = new StringBuilder();
        for (int i = 0; i < n; i++) {
            int index = 0;
            char[] chars = br.readLine().toCharArray();
            for (char val : chars) {
                index++;
                if (Character.isUpperCase(val) || Character.isLowerCase(val))
                    sb2.append(val);
                if (val == ' ' || index == chars.length) {
                    sb2.reverse();
                    sb.append(sb2).append(" ");
                    sb2.setLength(0);
                }
            }
            System.out.println(sb.toString());
            sb.setLength(0);
            sb2.setLength(0);
        }
    }
}
