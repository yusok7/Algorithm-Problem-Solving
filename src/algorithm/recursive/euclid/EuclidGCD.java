package algorithm.recursive.euclid;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class EuclidGCD {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int x = Integer.parseInt(br.readLine());
        int y = Integer.parseInt(br.readLine());

        int gcd = gcd(x, y);
        System.out.println(gcd);
    }

    public static int gcd(int x, int y) {
        if (y == 0)
            return x;
        else
            return gcd(y, x % y);
    }
}
