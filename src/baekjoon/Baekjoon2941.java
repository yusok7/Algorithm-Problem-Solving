package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Baekjoon2941 {
    public static void main(String[] args) throws IOException {

        String[] arr = {"c=", "c-", "dz=", "d-", "lj", "nj", "s=", "z="};

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();

        int count = 0;

        for (int i = 0; i < str.length() - 1; i++) {
            String[] strArr = str.split("");
            StringBuilder sb = new StringBuilder();
            sb.append(strArr[i]);
            for (int j = i + 1; j < str.length(); j++) {
                sb.append(strArr[j]);
                String string = sb.toString();
                if (Arrays.asList(arr).contains(string) && string.equals("dz=")) {
                    str = str.replaceFirst(string, "000");
                    count++;
                } else if (Arrays.asList(arr).contains(string)) {
                    str = str.replaceFirst(string, "00");
                    count++;
                }
            }
        }

        String[] result = str.split("");
        for (int i = 0; i < result.length; i++) {
            if (!result[i].equals("0")) {
                count++;
            }
        }
        System.out.println(count);
    }
}
