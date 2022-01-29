package baekjoon.bronze.bronze2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Baekjoon14954 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String n = br.readLine();
        String result = n;

        int sum = 0;
        int count = 0;
        while (true) {
            count++;
            String[] strArr = n.split("");
            int num = 0;
            sum = 0;
            for (String val : strArr) {
                num = Integer.parseInt(val);
                sum += num * num;
            }
            if (sum == 1) {
                System.out.println("HAPPY");
                break;
            } else if (count > 1000) {
                System.out.println("UNHAPPY");
                break;
            }
            n = String.valueOf(sum);
        }
    }
}
