package baekjoon.class2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Baekjoon1259 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while(true) {

            String input = br.readLine();
            if (input.equals("0")) {
                break;
            }

            String[] str = input.split("");

            List<String> list1 = new ArrayList<>();
            list1 = Arrays.asList(str);

            List<String> list2 = new ArrayList<>();
            for (String s : list1) {
                list2.add(0, s);
            }

            for (int i = 0; i < list1.size(); i++) {
                if (!list1.get(i).equals(list2.get(i))) {
                    System.out.println("no");
                    break;
                }

                if (i == list1.size()-1) {
                    System.out.println("yes");
                }
            }
        }
    }
}
