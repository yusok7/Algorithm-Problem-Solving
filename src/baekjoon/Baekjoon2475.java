package baekjoon;

import java.io.*;
import java.util.StringTokenizer;

public class Baekjoon2475 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int[] arr = new int[5];
        int sum = 0;
        int answer = 0;

        for (int i = 0; i < 5; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        for (int i : arr) {
            sum += i*i;
        }
        answer = sum % 10;

        bw.write(String.valueOf(answer));
        bw.flush();
        bw.close();
        br.close();


    }
}
