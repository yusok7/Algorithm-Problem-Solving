package baekjoon.silver.silver4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Baekjoon11656 {

    public static String[] strArr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        int length = str.length();
        strArr = new String[length];

        for (int i = 0; i < strArr.length; i++) {
            strArr[i] = str.substring(i);
        }

        Arrays.sort(strArr, (String o1, String o2) -> {
            if (o1.charAt(0) == o2.charAt(0)) {
                int min = Math.min(o1.length(), o2.length());
                for (int i = 0; i < min; i++) {
                    if (o1.charAt(i) != o2.charAt(i)) {
                        return o1.charAt(i) - o2.charAt(i);
                    }
                }
                return o1.length() - o2.length();
            } else {
                return o1.charAt(0) - o2.charAt(0);
            }
        });

        for (String s : strArr) {
            System.out.println(s);
        }
    }
}
