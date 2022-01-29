package baekjoon.bronze.bronze2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Baekjoon1592 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int l = Integer.parseInt(st.nextToken());

        if (m == 1) {
            System.out.println(0);
            System.exit(0);
        }

        int[] arr = new int[n + 1];
        arr[1] = 1;

        int count = 0;
        int num = 1;
        while (true) {
            if (arr[num] % 2 == 1) {
                int index = num;
                for (int i = 0; i < l; i++) {
                    if (++index > n) {
                        index = 1;
                    }
                }
                arr[index]++;
                num = index;
            } else {
                int index = num;
                for (int i = 0; i < l; i++) {
                    if (--index < 1) {
                        index = n;
                    }
                }
                arr[index]++;
                num = index;
            }
            int max = Arrays.stream(arr).max().getAsInt();
            count++;
            if (max == m) {
                System.out.println(count);
                break;
            }
        }
    }
}
