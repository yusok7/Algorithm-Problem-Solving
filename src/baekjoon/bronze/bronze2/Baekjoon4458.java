package baekjoon.bronze.bronze2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Baekjoon4458 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        for (int i = 0; i < n; i++) {
            StringBuilder sb = new StringBuilder();
            String str = br.readLine();
            String s = String.valueOf(str.charAt(0)).toUpperCase();
            sb.append(str).replace(0, 1, "");
            sb.insert(0, s);
            System.out.println(sb.toString());
        }
    }
}
