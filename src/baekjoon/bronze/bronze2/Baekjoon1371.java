package baekjoon.bronze.bronze2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Baekjoon1371 {

    private static int[] arr = new int[26];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = "";

        while ((str = br.readLine()) != null) {
            for (char c : str.toCharArray()) {
                if (Character.isLowerCase(c)) {
                    int num = c - 'a';
                    arr[num]++;
                }
            }
        }

        int max = Arrays.stream(arr)
                .max()
                .getAsInt();

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == max) {
                char c = (char) (i + 97);
                sb.append(c);
            }
        }
        System.out.println(sb.toString());
    }
}
