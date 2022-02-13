package baekjoon.silver.silver4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baekjoon1120 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        String[] xArr = st.nextToken().split("");
        String[] yArr = st.nextToken().split("");

        int min = 1000000;

        for (int i = 0; i <= yArr.length - xArr.length; i++) {
            int count = 0;
            for (int j = 0; j < xArr.length; j++) {
                if (!xArr[j].equals(yArr[j + i]))
                    count++;
            }
            min = Math.min(min, count);
        }
        System.out.println(min);
    }
}
