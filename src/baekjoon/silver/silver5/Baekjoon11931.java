package baekjoon.silver.silver5;

import java.io.*;
import java.util.Arrays;

public class Baekjoon11931 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());

        Integer[] arr = new Integer[n];

        for (int i = 0; i < n; i++) {
            int num = Integer.parseInt(br.readLine());
            arr[i] = num;
        }

        Arrays.sort(arr, (Integer o1, Integer o2) -> {
            return -(o1.compareTo(o2));
        });

        StringBuilder sb = new StringBuilder();
        for (Integer val : arr) {
            sb.append(val).append("\n");
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();

    }
}
