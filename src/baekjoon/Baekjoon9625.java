package baekjoon;

import java.io.*;

public class Baekjoon9625 {

    public static String[] d = new String[46];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        int countA = 0;
        int countB = 0;
        String str = "";

        d[0] = "A";
        d[1] = "B";

        for (int i = 2; i <= n; i++) {
            StringBuilder sb = new StringBuilder();
            sb.append(d[i-1]);
            sb.append(d[i-2]);
            d[i] = sb.toString();
        }
        str = d[n];

        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == 'A') countA++;
            else countB++;
        }

        bw.write(String.valueOf(countA) +" "+String.valueOf(countB));
        bw.flush();
        bw.close();
    }
}
