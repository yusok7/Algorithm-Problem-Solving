package baekjoon.bronze.bronze1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;

public class Baekjoon9047 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        for (int i = 0; i < n; i++) {
            String str = br.readLine();
            if (str.equals("6174")) {
                System.out.println(0);
                continue;
            }

            int count = 0;
            while (true) {
                count++;
                String[] strArr = str.split("");
                Arrays.sort(strArr, Collections.reverseOrder());
                String max = "";
                for (String s : strArr) {
                    max += s;
                }

                Arrays.sort(strArr);
                String min = "";
                for (String s : strArr) {
                    min += s;
                }

                str = String.valueOf(Integer.parseInt(max) - Integer.parseInt(min));
                if (str.equals("6174")) {
                    System.out.println(count);
                    break;
                }
                if (str.length() < 4) {
                    while (str.length() != 4) {
                        str += "0";
                    }
                }
            }
        }
    }
}
