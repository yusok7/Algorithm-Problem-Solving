package baekjoon.bronze.bronze2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Baekjoon2789 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] strArr = "CAMBRIDGE".split("");
        String str = br.readLine();

        for (String s : strArr) {
            str = str.replaceAll(s, "");
        }
        System.out.println(str);
    }
}
