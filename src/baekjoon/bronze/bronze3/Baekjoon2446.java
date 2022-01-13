package baekjoon.bronze.bronze3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Baekjoon2446 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < i; j++){
                sb.append(" ");
            }
            for (int j = 0; j < 2 * n - i * 2 - 1; j++) {
                sb.append("*");
            }
            sb.append("\n");
        }
        System.out.print(sb.toString());
        for (int i = 0; i < n - 1; i++) {
            System.out.print(" ");
        }
        System.out.println("*");
        sb.setLength(0);

        for (int i = n - 2; i >= 0; i--) {
            for (int j = 0; j < i; j++){
                sb.append(" ");
            }
            for (int j = 0; j < 2 * n - i * 2 - 1; j++) {
                sb.append("*");
            }
            sb.append("\n");
        }
        System.out.println(sb.toString());
    }
}
