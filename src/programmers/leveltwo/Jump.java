package programmers.leveltwo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Jump {

    public static int result = 0;

    public static void main(String[] args) {
        int n = 5;
        func(n);
        System.out.println(result);
    }

    public static void func(int n) {
        if (n == 0) {
            return;
        } else {
            if (n % 2 == 0) {
                n = n / 2;
            }
            else if (n % 2 == 1) {
                n = n / 2;
                result++;
            }
        }
        func(n);
    }

}