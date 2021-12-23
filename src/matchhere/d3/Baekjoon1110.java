package matchhere.d3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Baekjoon1110 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.parseInt(br.readLine());
        int result = num;
        int count = 0;

        StringBuilder sb = new StringBuilder();

        while (true) {
            count++;
            int firstNum = num % 10;
            int sum = num / 10 + num % 10;
            int lastNum = sum % 10;

            String str = sb.append(firstNum).append(lastNum).toString();

            if (Integer.parseInt(str) == result) {
                System.out.println(count);
                break;
            }
            num = Integer.parseInt(sb.toString());
            sb.setLength(0);
        }
    }
}
