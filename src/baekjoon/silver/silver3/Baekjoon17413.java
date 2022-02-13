package baekjoon.silver.silver3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Baekjoon17413 {
    private static StringBuilder sb1 = new StringBuilder();
    private static StringBuilder sb2 = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();

        boolean bool = false;
        for (int i = 0; i < input.length(); i++) {
            char c = input.charAt(i);
            if (Character.isLowerCase(c) || Character.isUpperCase(c) || Character.isDigit(c)) {
                sb2.append(c);
            } else if (c == ' ') {
                if (!bool) {
                    sb1.append(sb2.reverse().toString()).append(" ");
                    sb2.setLength(0);
                } else {
                    sb2.append(" ");
                }
            } else if (c == '<') {
                sb1.append(sb2.reverse().toString());
                sb2.setLength(0);
                sb2.append(c);
                bool = true;
            } else if (c == '>') {
                sb2.append(">");
                sb1.append(sb2.toString());
                sb2.setLength(0);
                bool = false;
            }
        }
        sb1.append(sb2.reverse().toString());
        System.out.println(sb1.toString());
    }
}
