package baekjoon.bronze.bronze2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Baekjoon1100 {

    public static String[][] arr = new String[8][8];
    public static int result = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for (int i = 0; i < 8; i++) {
            String[] strArr = br.readLine().split("");
            for (int j = 0; j < 8; j++) {
                arr[i][j] = strArr[j];
            }
        }

        for (int i = 0; i < 8; i++) {
            if (i % 2 == 0) {
                for (int j = 0; j < 8; j += 2) {
                    if (arr[i][j].equals("F")) {
                        result++;
                    }
                }
            } else if (i % 2 == 1) {
                for (int j = 1; j < 8; j += 2) {
                    if (arr[i][j].equals("F")) {
                        result++;
                    }
                }
            }
        }
        System.out.println(result);
    }
}
