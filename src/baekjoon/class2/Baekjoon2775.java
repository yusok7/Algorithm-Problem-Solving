package baekjoon.class2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Baekjoon2775 {
    public static int[][] arr = new int[15][14];

    public static void main(String[] args) throws IOException {
        func();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        for (int i = 0; i < t; i++) {
            int k = Integer.parseInt(br.readLine());
            int n = Integer.parseInt(br.readLine());
            System.out.println(arr[k][n-1]);
        }
    }

    public static void func() {
        for (int i = 0; i < 15; i++) {
            for (int j = 0; j < 14; j++) {
                if (i == 0) {
                    arr[0][j] = j+1;
                } else {
                    for (int k = 0; k <= j; k++) {
                        arr[i][j] += arr[i-1][k];
                    }
                }
            }
        }
    }

}
