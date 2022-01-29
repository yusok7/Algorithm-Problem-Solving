package baekjoon.bronze.bronze2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baekjoon1333 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int l = Integer.parseInt(st.nextToken());
        int d = Integer.parseInt(st.nextToken());

        int[] arr1 = new int[5000];
        int index1 = n * l + (n - 1) * 5;
        int count = 1;

        for (int i = 0; i < index1; i++) {
            if (count <= l) {
                arr1[i] = 1;
                count++;
            } else {
                for (int j = 0; j < 5; j++) {
                    arr1[i++] = 0;
                }
                i--;
                count = 1;
            }
        }

        int[] arr2 = new int[5000];
        arr2[0] = 1;
        for (int i = 1; i < 5000; i++) {
            if (i % d == 0) {
                arr2[i] = 1;
            }
        }

        for (int i = 0; i < 5000; i++) {
            if (arr1[i] == 0 && arr2[i] == 1) {
                System.out.println(i);
                break;
            }
        }
    }
}
