package baekjoon.class2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baekjoon4153 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int a = 0;
        int b = 0;
        int c = 0;

        while(true) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            a = Integer.parseInt(st.nextToken());
            b = Integer.parseInt(st.nextToken());
            c = Integer.parseInt(st.nextToken());

            if(a == 0 && b == 0 && c == 0) {
                break;
            }

            if(Math.pow(a, 2) + Math.pow(b, 2) == Math.pow(c, 2)) {
                System.out.println("right");
            } else if (Math.pow(b, 2) + Math.pow(c, 2) == Math.pow(a, 2)) {
                System.out.println("right");
            } else if (Math.pow(c, 2) + Math.pow(a, 2) == Math.pow(b, 2)) {
                System.out.println("right");
            } else {
                System.out.println("wrong");
            }
        }
    }
}
