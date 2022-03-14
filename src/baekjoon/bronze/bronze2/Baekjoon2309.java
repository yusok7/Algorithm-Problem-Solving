package baekjoon.bronze.bronze2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Baekjoon2309 {

    private static int[] arr = new int[9];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for (int i = 0; i < 9; i++)
            arr[i] = Integer.parseInt(br.readLine());
        Arrays.sort(arr);
        int sum = Arrays.stream(arr).sum();

        for (int i = 0; i < 8; i++) {
            for (int j = i + 1; j < 9; j++) {
                if (sum - arr[i] - arr[j] == 100) {
                    for (int k = 0; k < 9; k++) {
                        if (k == i || k == j)
                            continue;
                        System.out.println(arr[k]);
                    }
                    System.exit(0);
                }
            }
        }
    }
}
