package baekjoon.bronze.bronze2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Baekjoon10804 {

    public static int[] arr = new int[21];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for (int i = 0; i < 21; i++) {
            arr[i] = i;
        }

        for (int i = 0; i < 10; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            func(a, b);
        }

        for (int val : arr) {
            if (val == 0) continue;
            System.out.print(val + " ");
        }

    }

    public static void func(int x, int y) {
        List<Integer> list = new ArrayList<>();
        for (int i = x; i <= y; i++) {
            list.add(arr[i]);
        }
        Collections.reverse(list);
        int count = 0;
        for (int i = x; i <= y; i++) {
            arr[i] = list.get(count);
            count++;
        }
    }
}
