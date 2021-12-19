package baekjoon.silver.silver5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baekjoon10709 {

    public static String[][] arr1; // 초기
    public static String[][] arr2; // 결과

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        arr1 = new String[n][m];
        arr2 = new String[n][m];

        for (int i = 0; i < n; i++) {
            String[] strArr = br.readLine().split("");
            for (int j = 0; j < m; j++) {
                arr1[i][j] = strArr[j];
            }
        }

        for (int i = 0; i < n; i++) {
            boolean bool = false;
            int count = 1;
            for (int j = 0; j < m; j++) {
                if (arr1[i][j].equals("c")) {
                    bool = true;
                    count = 1;
                    arr2[i][j] = "0";
                } else if (arr1[i][j].equals(".") && bool == false) {
                    arr2[i][j] = "-1";
                } else if (arr1[i][j].equals(".") && bool == true) {
                    arr2[i][j] = String.valueOf(count);
                    count++;
                }
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                System.out.print(arr2[i][j] + " ");
            }
            System.out.println();
        }

    }
}
