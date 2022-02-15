package baekjoon.bronze.bronze2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Baekjoon11365 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringBuilder sb1 = new StringBuilder();
        StringBuilder sb2 = new StringBuilder();
        while (true) {
            String str = br.readLine();
            if (str.equals("END"))
                break;
            sb2.append(str).reverse();
            sb1.append(sb2.toString()).append("\n");
            sb2.setLength(0);
        }
        System.out.println(sb1.toString());
    }
}
