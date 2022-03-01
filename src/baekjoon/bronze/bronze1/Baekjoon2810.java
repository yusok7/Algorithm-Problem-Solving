package baekjoon.bronze.bronze1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Baekjoon2810 {

    private static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        br.readLine();
        String str = "*" + br.readLine();
        String[] strArr = str.split("");

        for (int i = 0; i < strArr.length; i++) {
            if (strArr[i].equals("S"))
                sb.append("S").append("*");
            else if (strArr[i].equals("L")) {
                sb.append("LL").append("*");
                i++;
            } else {
                sb.append("*");
            }
        }

        int answer = 0;
        boolean bool = true;
        str = sb.toString();
        for (char c : str.toCharArray()) {
            if (c == 'L')
                bool = false;
            if (c == '*')
                answer++;
        }
        answer = bool ? answer - 1 : answer;
        System.out.println(answer);
    }
}
