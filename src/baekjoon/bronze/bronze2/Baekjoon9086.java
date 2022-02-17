package baekjoon.bronze.bronze2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Baekjoon9086 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        for (int i = 0; i < n; i++) {
            StringBuilder sb = new StringBuilder();
            String str = br.readLine();
            if (str.length() == 1)
                sb.append(str).append(str);
            else
                sb.append(str.charAt(0)).append(str.charAt(str.length() - 1));
            System.out.println(sb.toString());
        }
    }
}
