package baekjoon.bronze.bronze1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baekjoon2740 {

    private static int[][] arr1;
    private static int[][] arr2;
    private static int[][] arr3;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n1 = Integer.parseInt(st.nextToken()); // arr1.length
        int m1 = Integer.parseInt(st.nextToken()); // arr1[0].length
        arr1 = new int[n1][m1];
        for (int i = 0; i < n1; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m1; j++) {
                arr1[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        st = new StringTokenizer(br.readLine());
        int n2 = Integer.parseInt(st.nextToken()); // arr2.length
        int m2 = Integer.parseInt(st.nextToken()); // arr2[0].length
        arr2 = new int[n2][m2];
        for (int i = 0; i < n2; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m2; j++) {
                arr2[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        arr3 = new int[n1][m2];

        for (int i = 0; i < n1; i++) { // 결과 행 수
            for (int j = 0; j < m2; j++) {
                for (int k = 0; k < m1; k++) {
                    arr3[i][j] += arr1[i][k] * arr2[k][j];
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n1; i++) {
            for (int j = 0; j < m2; j++) {
                sb.append(arr3[i][j]).append(" ");
            }
            sb.append("\n");
        }
        System.out.println(sb.toString());
    }
}
