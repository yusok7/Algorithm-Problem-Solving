package baekjoon.silver.silver5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Baekjoon1439 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        int white = 0;
        int black = 0;
        char[] charArr = str.toCharArray();
        if (charArr[0] == '1') black++;
        else if (charArr[0] == '0') white++;

        for (int i = 0; i < charArr.length-1; i++) {
            if (charArr[i] == '0' && charArr[i+1] == '1') black++;
            else if (charArr[i] == '1' && charArr[i+1] == '0') white++;
        }

        System.out.println(Math.min(white, black));
    }
}
