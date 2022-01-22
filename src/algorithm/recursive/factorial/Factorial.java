package algorithm.recursive.factorial;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Factorial {

    private static int factorial(int num) {
        if (num > 0) {
            return num * factorial(num - 1);
        } else {
            return 1;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        System.out.println("input num");
        int num = Integer.parseInt(br.readLine());

        System.out.println("결과: " + factorial(num));
    }
}
