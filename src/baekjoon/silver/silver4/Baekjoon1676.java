package baekjoon.silver.silver4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

public class Baekjoon1676 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        if (n == 0) {
            System.out.println(0);
            System.exit(0);
        }

        BigInteger num1 = new BigInteger(String.valueOf(n));
        for (int i = n - 1; i > 0; i--) {
            String str = String.valueOf(i);
            BigInteger num2 = new BigInteger(str);
            num1 = num1.multiply(num2);
        }
        String str = num1.toString();
        StringBuilder sb = new StringBuilder();
        str = sb.append(str).reverse().toString();

        int answer = 0;
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) != '0')
                break;
            answer++;
        }
        System.out.println(answer);
    }
}
