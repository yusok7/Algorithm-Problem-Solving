package baekjoon;

import java.io.*;
import java.util.StringTokenizer;

public class Baekjoon5086 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        while (true) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());
            if(n == 0 && m == 0) break;
            if (n % m == 0) {
                System.out.println("multiple");
            } else if (m % n == 0) {
                System.out.println("factor");
            } else {
                System.out.println("neither");
            }

        }
    }
}
