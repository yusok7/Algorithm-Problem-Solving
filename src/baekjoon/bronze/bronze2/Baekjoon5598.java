package baekjoon.bronze.bronze2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Baekjoon5598 {

    private static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[] charArr = br.readLine().toCharArray();

        for (char c : charArr) {
            int val = (c - 'A') - 3;
            if (val < 0)
                val += 26;
            c = (char) (val + 65);
            sb.append(c);
        }
        System.out.println(sb.toString());
    }
}
