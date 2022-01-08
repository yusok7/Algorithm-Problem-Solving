package baekjoon.silver.silver3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Baekjoon2630 {

    public static List<Integer> white = new ArrayList<>();
    public static List<Integer> blue = new ArrayList<>();

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
        System.out.println(white.size());
        System.out.println(blue.size());

    }

    /**
     * @param x 시작점
     * @param y 끝점
     * @param length 한변의 길이
     */
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

        if (bool) { // 사각형 안의 숫자가 모두 같지 않을 경우
            length = length / 2;
            func(x, y, length);
            func(x, y + length, length);
            func(x + length, y, length);
            func(x + length, y + length, length);
        } else { // 사각형 안의 숫자가 모두 같을 경우
            if (num == 0) {
                white.add(1);
                return;
            } else {
                blue.add(1);
                return;
            }
        }
    }
}
