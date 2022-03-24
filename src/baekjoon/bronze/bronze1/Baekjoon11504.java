package baekjoon.bronze.bronze1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baekjoon11504 {

    private static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testCase = Integer.parseInt(br.readLine());

        for (int i = 0; i < testCase; i++) {
            int answer = 0;
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());
            arr = new int[n];

            st = new StringTokenizer(br.readLine());
            StringBuilder sb = new StringBuilder();
            while (st.hasMoreTokens())
                sb.append(st.nextToken());
            int x = Integer.parseInt(sb.toString());

            sb.setLength(0);
            st = new StringTokenizer(br.readLine());
            while (st.hasMoreTokens())
                sb.append(st.nextToken());
            int y = Integer.parseInt(sb.toString());

            int index = 0;
            st = new StringTokenizer(br.readLine());
            while (st.hasMoreTokens())
                arr[index++] = Integer.parseInt(st.nextToken());

            for (int j = 0; j < n; j++) {
                int num = func(j, m);
                if (num >= x && num <= y)
                    answer++;
            }
            System.out.println(answer);
        }
    }

    private static int func(int startIndex, int m) {
        StringBuilder sb = new StringBuilder();
        int length = arr.length;
        for (int i = 0; i < m; i++) {
            if (startIndex == length)
                startIndex = 0;
            sb.append(arr[startIndex++]);
        }
        return Integer.parseInt(sb.toString());
    }
}
