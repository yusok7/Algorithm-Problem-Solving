package baekjoon.gold.gold4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baekjoon1806 {

    private static int min = 1000000;
    private static int count = 0;

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.valueOf(st.nextToken());
        int m = Integer.valueOf(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int[] arr = new int[n];

        for(int i = 0; i < n; i++) {
            arr[i] = Integer.valueOf(st.nextToken());
        }

        twoPointer(arr, m);

        if (count == 0)
            System.out.println(0);
        else
            System.out.println(min);
    }

    static void twoPointer(int[] arr, int m) {
        int startPoint = 0, endPoint = 0;
        int len = arr.length;
        int sum = 0;

        while(true) {
            if (sum >= m) {
                sum -= arr[startPoint++];
            } else if (endPoint >= len) {
                break;
            } else {
                sum += arr[endPoint++];
            }

            if(sum >= m) {
                count++;
                min = Math.min(min, endPoint - startPoint);
            }
        }
    }
}
