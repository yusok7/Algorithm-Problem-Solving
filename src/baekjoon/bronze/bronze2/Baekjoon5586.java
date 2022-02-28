package baekjoon.bronze.bronze2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Baekjoon5586 {

    private static int jResult, iResult = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] strArr = br.readLine().split("");

        for (int i = 0; i < strArr.length; i++) {
            boolean bool = false;
            if (strArr[i].equals("J") || strArr[i].equals("I")) {
                bool = func(i, strArr);
            }
            if (bool) {
                if (strArr[i].equals("J")) jResult++;
                else iResult++;
            }
        }
        System.out.println(jResult);
        System.out.println(iResult);
    }

    private static boolean func(int index, String[] arr) {
        if (index + 1 >= arr.length || index + 2 >= arr.length)
            return false;
        if (arr[index + 1].equals("O") && arr[index + 2].equals("I"))
            return true;
        return false;
    }
}
