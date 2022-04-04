package baekjoon.gold.gold5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Baekjoon3107 {

    private static List<String> list = new ArrayList<>();
    private static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        func2(str);
        if (list.size() == 8) {
            func3();
        } else {
            int zeroLength = 8 - list.size();
            String s2 = "";
            for (int i = 0; i < zeroLength; i++)
                s2 += ":0000";
            s2 += ":";
            str = str.replace("::", s2);
            list.clear();
            func2(str);
            func3();
        }
        System.out.println(sb.toString());
    }

    private static String func(String s) {
        if (s.length() == 4)
            return s;
        while (s.length() != 4)
            s = "0" + s;
        return s;
    }

    private static void func2(String str) {
        StringTokenizer st = new StringTokenizer(str, ":");
        while (st.hasMoreTokens())
            list.add(st.nextToken());
    }

    private static void func3() {
        for (int i = 0; i < list.size(); i++) {
            String s = func(list.get(i));
            if (i == list.size() - 1)
                sb.append(s);
            else
                sb.append(s).append(":");
        }
    }
}
