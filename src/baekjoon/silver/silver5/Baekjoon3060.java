package baekjoon.silver.silver5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Baekjoon3060 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[] opposite = {0, 4, 5, 6, 1, 2, 3};
        int[] arr = new int[7];

        for (int i = 0; i < n; i++) {
            int count = 1;
            int num = Integer.parseInt(br.readLine());
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= 6; j++) {
                arr[j] = Integer.parseInt(st.nextToken());
            }

            while (true) {
                int sum = Arrays.stream(arr).sum();
                if (sum > num) {
                    System.out.println(count);
                    break;
                }
                count++;
                func(arr, opposite);
            }
        }
    }

    public static void func(int[] arr, int[] opposite) {
        int[] arr2 = arr.clone();
        for (int i = 1; i < arr.length; i++) {
            int index1 = i - 1;
            int index2 = i + 1;
            if (index1 <= 0) {
                index1 = 6;
            }
            if (index2 > 6) {
                index2 = 1;
            }
            arr[i] = arr2[i] + arr2[index1] + arr2[index2] + arr2[opposite[i]];
        }
    }
}
