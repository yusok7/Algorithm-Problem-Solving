package baekjoon.bronze.bronze3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Baekjoon2445 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < i + 1; j++) {
                sb.append("*");
            }
            for (int j = 0; j < n - i - 1; j++) {
                sb.append(" ").append(" ");
            }
            for (int j = 0; j < i + 1; j++) {
                sb.append("*");
            }
            sb.append("\n");
        }
        System.out.print(sb.toString());
        String str = sb.reverse().toString();
        for (int i = 0; i < n; i++) {
            System.out.print("**");
        }
        System.out.println(str);
    }
}
