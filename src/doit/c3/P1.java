package doit.c3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P1 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String str = br.readLine();

        int answer = 0;
        for (int i = 0; i < n; i++) {
            answer += str.charAt(i) - '0';
        }
        System.out.println(answer);
    }
}
