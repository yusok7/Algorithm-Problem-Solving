package baekjoon;

import java.io.*;
import java.util.StringTokenizer;

public class Baekjoon2920 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        String answer = "mixed";
        int count = 0;

        int[] arr = new int[8];

        for (int i = 0; i < 8; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        if(arr[0] == 1) {
            for(int i=0; i<8; i++) {
                if(arr[i] == i+1) {
                    count ++;
                }
                if (count == 8) {
                    answer = "ascending";
                }
            }
        }

        if(arr[0] == 8) {
            for(int i=0; i<8; i++) {
                if(arr[i] == 8-i) {
                    count ++;
                }
                if (count == 8) {
                    answer = "descending";
                }
            }
        }

        bw.write(answer);
        bw.flush();
        bw.close();
        br.close();

    }
}
