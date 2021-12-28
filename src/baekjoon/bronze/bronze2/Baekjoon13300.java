package baekjoon.bronze.bronze2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baekjoon13300 {

    public static int[][] arr = new int[6][2];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        if (k == 1) {
            System.out.println(n);
            System.exit(0);
        }

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int gender = Integer.parseInt(st.nextToken());
            int grade = Integer.parseInt(st.nextToken()) - 1;
            arr[grade][gender]++;
        }

        int result = 0;
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                if (arr[i][j] % k == 0) {
                    result += arr[i][j] / k;
                } else {
                    result += arr[i][j] / k + 1;
                }
            }
        }
        System.out.println(result);
    }
}
