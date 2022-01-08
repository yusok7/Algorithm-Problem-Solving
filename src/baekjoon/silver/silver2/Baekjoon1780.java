package baekjoon.silver.silver2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baekjoon1780 {

    public static int a, b, c;
    public static int[][] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        arr = new int[n][n];

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        func(0, 0, n);
        System.out.println(a);
        System.out.println(b);
        System.out.println(c);
    }

    public static void func(int x, int y, int length) {
        boolean bool = false;
        int num = arr[x][y];

        for (int i = x; i < x + length; i++) {
            for (int j = y; j < y + length; j++) {
                if (arr[i][j] != num) {
                    bool = true;
                }
            }
        }

        if (bool) {
            length = length / 3;
            func(x, y, length);
            func(x, y + length, length);
            func(x, y + length * 2, length);
            func(x + length, y, length);
            func(x + length, y + length, length);
            func(x + length, y + length * 2, length);
            func(x + length * 2, y, length);
            func(x + length * 2, y + length, length);
            func(x + length * 2, y + length * 2, length);
        } else {
            if (num == -1) a++;
            else if (num == 0) b++;
            else if (num == 1) c++;
            return;
        }
    }
}
