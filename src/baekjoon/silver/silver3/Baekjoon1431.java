package baekjoon.silver.silver3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Baekjoon1431 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        String[] arr = new String[n];

        for (int i = 0; i < n; i++) {
            arr[i] = br.readLine();
        }

        Arrays.sort(arr, (String o1, String o2) -> {
            if (o1.length() != o2.length()) {
                return o1.length() - o2.length();
            }
            char[] charArr1 = o1.toCharArray();
            char[] charArr2 = o2.toCharArray();
            int sum1 = 0;
            int sum2 = 0;
            for (char val : charArr1) {
                if (Character.isDigit(val)) {
                    sum1 += Integer.parseInt(String.valueOf(val));
                }
            }
            for (char val : charArr2) {
                if (Character.isDigit(val)) {
                    sum2 += Integer.parseInt(String.valueOf(val));
                }
            }
            if (sum1 < sum2) {
                return -1;
            } else if (sum1 > sum2) {
                return 1;
            } else {
                return o1.compareTo(o2);
            }
        });

        for (String s : arr) {
            System.out.println(s);
        }
    }
}
