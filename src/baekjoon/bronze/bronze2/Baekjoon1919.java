package baekjoon.bronze.bronze2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Baekjoon1919 {

    private static int[] arr = new int[26];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str1 = br.readLine();
        String str2 = br.readLine();

        for (char c : str1.toCharArray()) {
            arr[c - 'a']++;
        }
        for (char c : str2.toCharArray()) {
            arr[c - 'a']--;
        }

        int answer = 0;
        for (int val : arr) {
            answer += Math.abs(val);
        }
        System.out.println(answer);
    }
}
