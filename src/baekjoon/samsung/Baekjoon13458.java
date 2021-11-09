package baekjoon.samsung;

import java.io.*;
import java.util.StringTokenizer;

public class Baekjoon13458 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        long count = 0;
        long answer = 0;

        // 시험장 갯수
        int N = Integer.parseInt(br.readLine());

        // 각 시험장별 응시자 수
        long[] arr = new long[N];
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        long[] arr2 = new long[2];
        st = new StringTokenizer(br.readLine(), " ");
        arr2[0] = Integer.parseInt(st.nextToken());
        arr2[1] = Integer.parseInt(st.nextToken());

        for (int i=0; i<arr.length; i++) {
            arr[i] = arr[i] - arr2[0];
            count++;
        }

        // 이미 총 감독관으로 다 채워진경우
        for (int i=0; i<arr.length; i++) {
            if (arr[i] == 0 && i == arr.length-1) {
                answer = 1;
            }
        }

        if (answer == 1) {
            bw.write(String.valueOf(count));
            bw.flush();
            bw.close();
            br.close();
        } else {
            for (int i=0; i<arr.length; i++) {
                while (true) {
                    arr[i] = arr[i] - arr2[1];
                    count++;
                    if (arr[i] <= 0) {
                        break;
                    }
                }
            }
            bw.write(String.valueOf(count));
            bw.flush();
            bw.close();
            br.close();
        }
    }
}
