package baekjoon.gold.gold4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Baekjoon5052 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        for (int i = 0; i < t; i++) {
            int n = Integer.parseInt(br.readLine());
            String[] arr = new String[n];
            for (int j = 0; j < n; j++) {
                arr[j] = br.readLine();
            }

            Arrays.sort(arr);

            String answer = func(arr.length, arr) ? "YES" : "NO";
            System.out.println(answer);
        }
    }

    public static boolean func(int length, String[] arr) {
        for (int i = 0; i < length - 1; i++) {
            if (arr[i + 1].startsWith(arr[i]))
                return false;
        }
        return true;
    }
}
