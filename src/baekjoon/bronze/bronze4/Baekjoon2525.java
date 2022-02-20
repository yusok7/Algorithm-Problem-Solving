package baekjoon.bronze.bronze4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baekjoon2525 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int h = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int time = Integer.parseInt(br.readLine());

        int a = (m + time) / 60;
        int b = (m + time) % 60;

        h = h + a;
        m = b;

        if (h >= 24)
            h = h - 24;

        System.out.println(h + " " + m);
    }
}
