package baekjoon.silver.silver5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Baekjoon2947 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] strArr = br.readLine().split(" ");

        while (true) {
            for (int i = 0; i < strArr.length - 1; i++) {
                int num1 = Integer.parseInt(strArr[i]);
                int num2 = Integer.parseInt(strArr[i + 1]);

                if (num1 > num2) {
                    strArr[i] = String.valueOf(num2);
                    strArr[i + 1] = String.valueOf(num1);
                    for (String s : strArr) {
                        System.out.print(s + " ");
                    }
                    System.out.print("\n");
                }
            }
            String str = "";
            for (String s : strArr) {
                str += s;
            }
            if (str.equals("12345")) break;
        }
    }
}
