package baekjoon.silver.silver4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Baekjoon2870 {

    public static StringBuilder sb = new StringBuilder();
    public static List<BigInteger> list = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        for (int i = 0; i < n; i++) {
            String str = br.readLine().toLowerCase();
            char[] charArr = str.toCharArray();
            for (int j = 0; j < charArr.length - 1; j++) {
                if (Character.isDigit(charArr[j])) {
                    sb.append(charArr[j]);
                }
                if (Character.isDigit(charArr[j]) && Character.isLowerCase(charArr[j+1])) {
                    list.add(new BigInteger(sb.toString()));
                    sb.setLength(0);
                }
                if (j == charArr.length - 2) {
                    if (Character.isDigit(charArr[j + 1])) {
                        sb.append(charArr[j+1]);
                        list.add(new BigInteger(sb.toString()));
                        sb.setLength(0);
                    }
                }
            }
        }
        Collections.sort(list);
        for (BigInteger val : list) {
            System.out.println(val);
        }
    }
}
