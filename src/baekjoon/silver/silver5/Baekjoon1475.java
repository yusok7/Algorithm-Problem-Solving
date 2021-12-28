package baekjoon.silver.silver5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Baekjoon1475 {

    public static int[] arr = new int[10];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] numArr = br.readLine().split("");

        for (String val : numArr) {
            int num = Integer.parseInt(val);
            if (num == 6 || num == 9) {
                arr[9]++;
            } else {
                arr[num]++;
            }
        }

        arr[9]++;
        arr[9] = arr[9] / 2;

        int max = arr[0];
        for (int i = 0; i < 10; i++) {
            max = Math.max(arr[i], max);
        }
        System.out.println(max);
    }
}
