package baekjoon.class3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Baekjoon5525 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());
        int count = n * 2 + 1;
        String str = br.readLine();
        String[] strArr = str.split("");
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < count; i++) {
            if (i%2 == 0) {
                sb.append("I");
            } else {
                sb.append("O");
            }
        }
        String str2 = sb.toString();
        int result = 0;
        for (int i = 0; i < m; i++) {
            String string = "";
            if (strArr[i].equals("I")) {
                try {
                    string = str.substring(i, i+count);
                    if (string.equals(str2)) {
                        result++;
                    }
                }
                catch (Exception e) {

                }
            }
        }
        System.out.println(result);
    }
}
