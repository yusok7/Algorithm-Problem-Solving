package baekjoon.silver.silver4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Baekjoon1543 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String a = br.readLine();
        String b = br.readLine();

        int count = 0;
        while (true) {
            if (!a.contains(b)) break;
            else {
                a= a.replaceFirst(b,"-");
                count++;
            }
        }
        System.out.println(count);
    }
}
