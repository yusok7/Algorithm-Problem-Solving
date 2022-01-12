package baekjoon.bronze.bronze1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Baekjoon1032 {

    public static List<String[]> list = new ArrayList<>();
    public static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        for (int i = 0; i < n; i++) {
            String[] strArr = br.readLine().split("");
            list.add(strArr);
        }

        int length = list.get(0).length;

        for (int i = 0; i < length; i++) {
            boolean bool = false;
            for (int j = 0; j < n - 1; j++) {
                if (!list.get(j)[i].equals(list.get(j + 1)[i])) {
                    bool = true;
                    break;
                }
            }
            if (bool) {
                sb.append("?");
            } else {
                sb.append(list.get(0)[i]);
            }
        }
        System.out.println(sb.toString());
    }
}
