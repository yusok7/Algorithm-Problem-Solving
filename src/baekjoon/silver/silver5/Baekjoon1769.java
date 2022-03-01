package baekjoon.silver.silver5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Baekjoon1769 {

    private static int result = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        String answer = func(str) ? "YES" : "NO";
        System.out.println(result);
        System.out.println(answer);
    }

    private static boolean func(String str) {
        if (str.length() == 1) {
            int num = Integer.parseInt(str);
            if (num % 3 == 0)
                return true;
            return false;
        }
        result++;
        long sum = 0;
        for (char c : str.toCharArray()) {
            int num = c - '0';
            sum += num;
        }
        str = String.valueOf(sum);
        return func(str);
    }
}
