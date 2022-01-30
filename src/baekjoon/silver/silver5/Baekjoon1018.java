package baekjoon.silver.silver5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Baekjoon1018 {

    private static String[][] white = new String[8][8];
    private static String[][] black = new String[8][8];
    private static String[][] strArr = new String[8][8];
    private static String[][] arr;
    private static List<Integer> list = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        setWhiteBlack();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        arr = new String[n][m];
        for (int i = 0; i < n; i++) {
            String[] split = br.readLine().split("");
            for (int j = 0; j < m; j++) {
                arr[i][j] = split[j];
            }
        }

        for (int i = 0; i <= n - 8; i++) {
            for (int j = 0; j <= m - 8; j++) {
                func(i, j);
            }
        }
        System.out.println(Collections.min(list));
    }

    private static void setWhiteBlack() {
        for (int i = 0; i < 8; i++) {
            if (i % 2 == 0) {
                for (int j = 0; j < 8; j++) {
                    if (j % 2 == 0) {
                        white[i][j] = "W";
                        black[i][j] = "B";
                    } else if (j % 2 == 1){
                        white[i][j] = "B";
                        black[i][j] = "W";
                    }
                }
            } else if (i % 2 == 1){
                for (int j = 0; j < 8; j++) {
                    if (j % 2 == 0) {
                        white[i][j] = "B";
                        black[i][j] = "W";
                    } else if (j % 2 == 1){
                        white[i][j] = "W";
                        black[i][j] = "B";
                    }
                }
            }
        }
    }

    private static void func(int i, int j) {
        int row = 0;
        for (int a = i; a < i + 8; a++) {
            int col = 0;
            for (int b = j; b < j + 8; b++) {
                strArr[row][col++] = arr[a][b];
            }
            row++;
        }
        func2(strArr, white);
        func2(strArr, black);
    }

    private static void func2(String[][] arr1, String[][] arr2) {
        int result = 0;
        for (int i = 0 ; i < 8 ; i++) {
            for (int j = 0; j < 8; j++) {
                if (!arr1[i][j].equals(arr2[i][j])) {
                    result++;
                }
            }
        }
        list.add(result);
    }
}
