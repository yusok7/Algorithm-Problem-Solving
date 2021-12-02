package baekjoon.silver.silver3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Baekjoon1141 {

    public static List<String> list = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String[] strArr = new String[n];

        for (int i = 0; i < n; i++) {
            strArr[i] = br.readLine();
        }

        Arrays.sort(strArr, (String o1, String o2) -> {
            return o1.length() - o2.length();
        });

        for (String s : strArr) {
            list.add(s);
        }

        int count = 0;
        for (int i = 0; i < n; i++) {
            String str = list.get(i);
            boolean bool = true;
            for (int j = i + 1; j < n; j++) {
                if (list.get(j).startsWith(str)) {
                    list.set(i, "");
                    bool = false;
                    break;
                }
            }
            if (bool) count++;
        }

        System.out.println(count);
    }
}
