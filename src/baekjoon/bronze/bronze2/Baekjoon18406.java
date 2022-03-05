package baekjoon.bronze.bronze2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Baekjoon18406 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        int length = str.length() / 2;

        int num1 = 0;
        int num2 = 0;

        for (int i = 0; i < length; i++) {
            int num = Integer.parseInt(String.valueOf(str.charAt(i)));
            num1 += num;
        }

        for (int i = length; i < str.length(); i++) {
            int num = Integer.parseInt(String.valueOf(str.charAt(i)));
            num2 += num;
        }

        if (num1 == num2)
            System.out.println("LUCKY");
        else
            System.out.println("READY");
    }
}
