package baekjoon.bronze.bronze2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Baekjoon10820 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = "";
        while ((str = br.readLine()) != null) {
            int a = 0;
            int b = 0;
            int c = 0;
            int d = 0;

            char[] charArr = str.toCharArray();

            for (char val : charArr) {
                if (Character.isUpperCase(val)) {
                    b++;
                } else if (Character.isLowerCase(val)) {
                    a++;
                } else if (Character.isDigit(val)) {
                    c++;
                } else {
                    d++;
                }
            }
            System.out.println(a + " " + b + " " + c + " " + d);
        }
    }
}
