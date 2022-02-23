package baekjoon.bronze.bronze2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Baekjoon10821 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();

        int result = 1;
        for (char c : str.toCharArray()) {
            if (!Character.isDigit(c))
                result++;
        }
        System.out.println(result);
    }
}
