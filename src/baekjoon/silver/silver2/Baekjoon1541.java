package baekjoon.silver.silver2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Baekjoon1541 {

    public static List<Integer> list = new ArrayList<>();
    public static List<String> list2 = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        char[] charArr = str.toCharArray();

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < charArr.length; i++) {
            if (Character.isDigit(charArr[i])) {
                sb.append(charArr[i]);
            } else {
                int number = Integer.parseInt(sb.toString());
                list.add(number);
                sb.setLength(0);
                list2.add(String.valueOf(charArr[i]));
            }
            if (i == charArr.length - 1) {
                int number = Integer.parseInt(sb.toString());
                list.add(number);
            }
        }

        int index = 0;
        boolean bool = false;
        for (int i = 0; i < list2.size(); i++) {
            if (list2.get(i).equals("-")) {
                index = i;
                bool = true;
                break;
            }
        }

        int sum = 0;
        if (!bool) {
            for (Integer val : list) {
                sum += val;
            }
            System.out.println(sum);
            System.exit(0);
        }

        int sum2 = 0;
        for (int i = index + 1; i < list.size(); i++) {
            sum2 += list.get(i);
        }

        int sum1 = 0;
        for (int i = 0; i <= index; i++) {
            sum1 += list.get(i);
        }

        System.out.println((sum2 - sum1) * -1);
    }
}
