package baekjoon.bronze.bronze4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Baekjoon14470 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int a = Integer.parseInt(br.readLine());
        int b = Integer.parseInt(br.readLine());
        int c = Integer.parseInt(br.readLine());
        int d = Integer.parseInt(br.readLine());
        int e = Integer.parseInt(br.readLine());

        int time = 0;
        if (a > 0) {
            System.out.println((b - a) * e);
        } else {
            time += melt(a, c);
            time += d;
            time += b * e;
            System.out.println(time);
        }
    }

    private static int melt(int a, int c) {
        return a * (-1) * c;
    }
}
