package baekjoon.bronze.bronze2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baekjoon1225 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        String str1 = st.nextToken();
        String str2 = st.nextToken();

        long sum = 0;
        for (int i = 0; i < str1.length(); i++) {
            int num1 = str1.charAt(i) - '0';
            for (int j = 0; j < str2.length(); j++) {
                int num2 = str2.charAt(j) - '0';
                sum += num1 * num2;
            }
        }
        System.out.println(sum);
    }
}
