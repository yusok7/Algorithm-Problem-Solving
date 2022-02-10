package baekjoon.bronze.bronze2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baekjoon5566 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[] arr1 = new int[n];
        for (int i = 0; i < n; i++)
            arr1[i] = Integer.parseInt(br.readLine());

        int[] arr2 = new int[m];
        for (int i = 0; i < m; i++)
            arr2[i] = Integer.parseInt(br.readLine());

        int index = 0;
        int count = 0;
        for (int val : arr2) {
            // 주사위에 나온 수 만큼 이동
            count++;
            index = index + val;
            if (check(index, n - 1)) {
                System.out.println(count);
                break;
            }

            int num = arr1[index];
            if (num == 0)
                continue;
            else
                index += num;

            if (check(index, n - 1)) {
                System.out.println(count);
                break;
            }

        }
    }

    private static boolean check(int index, int last) {
        if (index >= last)
            return true;
        return false;
    }
}
