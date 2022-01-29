package baekjoon.bronze.bronze2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Baekjoon21756 {
    public static void main(String[] args) throws IOException {
        List<Integer> list1 = new ArrayList<>();
        List<Integer> list2 = new ArrayList<>();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.parseInt(br.readLine());

        if (num == 1) {
            System.out.println(1);
            System.exit(0);
        }

        for (int i = 1; i <= num; i++) {
            list1.add(i);
        }

        while (true) {
            if (list1.size() == 0) {
                for (int i = 0; i < list2.size(); i++) {
                    if (i % 2 == 1) {
                        int a = list2.get(i);
                        list1.add(a);
                    }
                }
                if (list1.size() == 1) {
                    System.out.println(list1.get(0));
                    break;
                }
                list2.clear();
                continue;
            } else if (list2.size() == 0) {
                for (int i = 0; i < list1.size(); i++) {
                    if (i % 2 == 1) {
                        int a = list1.get(i);
                        list2.add(a);
                    }
                }
                if (list2.size() == 1) {
                    System.out.println(list2.get(0));
                    break;
                }
                list1.clear();
                continue;
            }
        }
    }
}
