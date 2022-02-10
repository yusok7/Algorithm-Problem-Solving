package baekjoon.bronze.bronze1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baekjoon11504 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testCase = Integer.valueOf(br.readLine());

        for (int i = 0; i < testCase; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());
            int[] arr = new int[n];

            StringBuilder sb = new StringBuilder();
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++)
                sb.append(st.nextToken());
            int x = Integer.parseInt(sb.toString());
            sb.setLength(0);

            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++)
                sb.append(st.nextToken());
            int y = Integer.parseInt(sb.toString());
            sb.setLength(0);

            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++)
                arr[j] = Integer.parseInt(st.nextToken());

            int result = 0;
            for (int j = 0; j < n; j++) {
                int index = j;
                int index2 = j + 1;
                int index3 = j + 2;
                if (index2 >= n)
                    index2 -= n;
                if (index3 >= n)
                    index3 -= n;
                int num = Integer.parseInt(sb.append(arr[index]).append(arr[index2]).append(arr[index3]).toString());
                if (num >= x && num <= y)
                    result++;
                sb.setLength(0);
            }
            System.out.println(result);
        }
    }
}
