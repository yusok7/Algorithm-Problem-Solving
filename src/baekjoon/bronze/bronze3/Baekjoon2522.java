package baekjoon.bronze.bronze3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Baekjoon2522 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();

        for (int i = n - 1; i > 0; i--) {
            for (int j = 0; j < i; j++) {
                sb.append(" ");
            }
            for (int j = i; j < n; j++) {
                sb.append("*");
            }
            if (i == 1) break;
            sb.append("\n");
        }
        System.out.println(sb.toString());
        sb.setLength(0);
        for (int i = 0; i < n; i++) {
            System.out.print("*");
        }
        System.out.println();

        for (int i = 0; i < n -1; i++) {
            for (int j = 0; j <= i; j++) {
                sb.append(" ");
            }
            for (int j = n - i - 1; j > 0; j--) {
                sb.append("*");
            }
            sb.append("\n");
        }
        System.out.println(sb.toString());
    }
}
