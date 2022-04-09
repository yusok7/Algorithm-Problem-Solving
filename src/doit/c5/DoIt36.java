package doit.c5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class DoIt36 {

    private static List<Integer> numbers = new ArrayList<>();
    private static List<Character> list = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        StringTokenizer st = new StringTokenizer(str, "+,-");

        while (st.hasMoreTokens())
            numbers.add(Integer.parseInt(st.nextToken()));

        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if (!Character.isDigit(c))
                list.add(c);
        }

        int sum = numbers.get(0);
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i) == '+') {
                sum += numbers.get(i + 1);
            } else {
                while (true) {
                    sum -= numbers.get(i++ + 1);
                    if (i == list.size())
                        break;
                }
            }
        }
        System.out.println(sum);
    }
}
