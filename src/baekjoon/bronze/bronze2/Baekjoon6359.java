package baekjoon.bronze.bronze2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Baekjoon6359 {

    public static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testCase = Integer.parseInt(br.readLine());

        for (int i = 0; i < testCase; i++) {
            int n = Integer.parseInt(br.readLine());
            arr = new int[n + 1];
            for (int j = 1; j < arr.length; j++) {
                arr[j] = 1;
            }

            int count = 1;
            for (int j = 2; j <= n; j++) {
                while (true) {
                    int index = j * count;
                    if (index <= n) {
                        if (arr[index] == 0) {
                            arr[index] = 1;
                        } else {
                            arr[index] = 0;
                        }
                    } else {
                        break;
                    }
                    count++;
                }
                count = 1;
            }

            int result = 0;
            for (int val : arr) {
                if (val == 1) {
                    result++;
                }
            }
            System.out.println(result);
        }
    }
}
