package baekjoon.bronze.bronze2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Baekjoon5988 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        for (int i = 0; i < n; i++) {
            String str = br.readLine();
            int index = str.length() - 1;
            int val = str.charAt(index) - '0';
            if (val % 2 == 1)
                System.out.println("odd");
            else
                System.out.println("even");
        }
    }
}
