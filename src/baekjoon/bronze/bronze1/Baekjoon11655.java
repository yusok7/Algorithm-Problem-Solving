package baekjoon.bronze.bronze1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Baekjoon11655 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        for (char c : br.readLine().toCharArray()) {
            if (Character.isUpperCase(c)) {
                int num = c + 13;
                c = num > 90 ? (char)(num - 26) : (char)num;
                sb.append(c);
            } else if (Character.isLowerCase(c)) {
                int num = c + 13;
                c = num > 122 ? (char)(num - 26) : (char)num;
                sb.append(c);
            } else {
                sb.append(c);
            }
        }
        System.out.println(sb.toString());
    }
}
