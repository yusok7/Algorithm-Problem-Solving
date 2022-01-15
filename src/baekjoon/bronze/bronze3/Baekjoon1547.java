package baekjoon.bronze.bronze3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baekjoon1547 {

    public static int[] arr = new int[4];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        for (int i = 1; i <= 3; i++) {
            arr[i] = i;
        }

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int xIndex = 0;
            int y = Integer.parseInt(st.nextToken());
            int yIndex = 0;
            int z = 0;

            for (int j = 1; j <= 3; j++) {
                if (arr[j] == x) xIndex = j;
                if (arr[j] == y) yIndex = j;
            }

            z = arr[xIndex];
            arr[xIndex] = y;
            arr[yIndex] = z;
        }

        System.out.println(arr[1]);

    }
}
