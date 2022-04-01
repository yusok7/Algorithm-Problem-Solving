package baekjoon.bronze.bronze2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baekjoon5218 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        for (int i = 0; i < n; i++) {
            StringBuilder sb = new StringBuilder();
            StringTokenizer st = new StringTokenizer(br.readLine());
            String str1 = st.nextToken();
            String str2 = st.nextToken();
            for (int j = 0; j < str1.length(); j++) {
                int num1 = str1.charAt(j);
                int num2 = str2.charAt(j);
                if (num2 >= num1)
                    sb.append(num2 - num1).append(" ");
                else
                    sb.append((num2 + 26) - num1).append(" ");
            }
            System.out.println("Distances: " + sb.toString());
        }
    }
}
