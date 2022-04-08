package doit.c4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class DoIt15 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        if (n == 1) {
            System.out.println(arr[0]);
            System.exit(0);
        }

        int length = arr.length - 1;
        while (true) {
            swap(length--, arr);
            if (length == 0)
                break;
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < arr.length; i++)
            sb.append(arr[i]).append("\n");

        System.out.println(sb.toString());
    }

    private static void swap(int length, int[] arr) {
        for (int i = 0; i < length; i++) {
            if (arr[i] > arr[i + 1]) {
                int num = arr[i];
                arr[i] = arr[i + 1];
                arr[i + 1] = num;
            }
        }
    }
}
