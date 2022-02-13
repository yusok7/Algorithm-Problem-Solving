package baekjoon.bronze.bronze1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baekjoon1357 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int x = func(st.nextToken());
        int y = func(st.nextToken());

        System.out.println(func(String.valueOf(x + y)));
    }

    private static int func(String str) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < str.length(); i++)
            sb.append(str.charAt(i));
        return Integer.parseInt(sb.reverse().toString());
    }
}
