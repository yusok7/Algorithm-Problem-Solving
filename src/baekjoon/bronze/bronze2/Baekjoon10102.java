package baekjoon.bronze.bronze2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Baekjoon10102 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String str = br.readLine();

        int a = 0;
        int b = 0;

        for (char c : str.toCharArray()) {
            if (c == 'A') a++;
            if (c == 'B') b++;
        }

        if (a == b)
            System.out.println("Tie");
        else
            System.out.println(a > b ? "A" : "B");
    }
}
