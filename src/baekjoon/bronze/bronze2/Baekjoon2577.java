package baekjoon.bronze.bronze2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Baekjoon2577 {

    public static int[] arr = new int[10];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int a = Integer.parseInt(br.readLine());
        int b = Integer.parseInt(br.readLine());
        int c = Integer.parseInt(br.readLine());

        int result = a * b * c;
        String[] strArr = String.valueOf(result).split("");

        for (String val : strArr) {
            int index = Integer.parseInt(val);
            arr[index]++;
        }

        for (int val : arr) {
            System.out.println(val);
        }
    }
}
