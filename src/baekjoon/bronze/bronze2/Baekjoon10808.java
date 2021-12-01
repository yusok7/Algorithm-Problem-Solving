package baekjoon.bronze.bronze2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Baekjoon10808 {

    public static int[] arr = new int[26];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[] charArr = br.readLine().toCharArray();

        for (char c : charArr) {
            int i = Integer.parseInt(String.valueOf(c-'a'));
            arr[i] += 1;
        }

        for (int i : arr) {
            System.out.print(i + " ");
        }
    }
}
