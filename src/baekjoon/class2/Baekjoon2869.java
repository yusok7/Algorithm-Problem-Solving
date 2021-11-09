package baekjoon.class2;

import java.io.*;
import java.util.StringTokenizer;

public class Baekjoon2869 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        int v = Integer.parseInt(st.nextToken());
        int distance = 0;
        int day = 0;

        while (true) {
            day += 1; // 일차 증가
            distance += a;
            if (distance >= v) {
                break;
            }
            distance -= b;
        }
        bw.write(String.valueOf(day));
        bw.flush();
        bw.close();
        br.close();
    }
}
