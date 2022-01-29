package baekjoon.bronze.bronze3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Baekjoon3028 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        int[] arr = {1, 0, 0};

        for (int i = 0; i < str.length(); i++) {
            String val = String.valueOf(str.charAt(i));
            if (val.equals("A"))
                func1(arr);
            if (val.equals("B"))
                func2(arr);
            if (val.equals("C"))
                func3(arr);
        }

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 1)
                System.out.println(i + 1);
        }

    }

    // a <-> b
    private static void func1(int[] arr) {
        int c = arr[0];
        arr[0] = arr[1];
        arr[1] = c;
    }

    private static void func2(int[] arr) {
        int c = arr[1];
        arr[1] = arr[2];
        arr[2] = c;
    }

    private static void func3(int[] arr) {
        int c = arr[0];
        arr[0] = arr[2];
        arr[2] = c;
    }

}
