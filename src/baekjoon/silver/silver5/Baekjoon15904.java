package baekjoon.silver.silver5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Baekjoon15904 {

    private static String[] strArr = {"U", "C", "P", "C"};
    private static boolean[] bool = new boolean[4];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < str.length(); i++) {
            if (Character.isUpperCase(str.charAt(i)))
                sb.append(str.charAt(i));
        }

        str = sb.toString();

        int index = 0;
        for (int i = 0; i < str.length(); i++) {
            if (index == 4)
                break;
            String val = String.valueOf(str.charAt(i));
            if (val.equals(strArr[index])) {
                bool[index] = true;
                index++;
            }
        }

        boolean isTrue = true;
        for (int i = 0; i < 4; i++) {
            if (bool[i] == false) {
                isTrue = false;
                break;
            }
        }
        if (isTrue) {
            System.out.println("I love UCPC");
        } else {
            System.out.println("I hate UCPC");
        }
    }
}
