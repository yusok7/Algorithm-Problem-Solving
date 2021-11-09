package baekjoon;

import java.io.*;

public class Baekjoon1436 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        int start = 666;
        int add = 0;
        int count = 0;
        int answer = 0;

        while (true) {
            String number = String.valueOf(start+add);
            if (number.contains("666")) {
                count ++;
            }

            if (count == n) {
                answer = Integer.parseInt(number);
                break;
            }
            add++;
        }
        bw.write(String.valueOf(answer));
        bw.flush();
        bw.close();
        br.close();
    }
}
