package baekjoon.bronze.bronze1;

import java.util.*;
import java.io.*;

public class Baekjoon1193 {

    private static List<Integer> list = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        func();

        int index = 0;
        int startIndex = 0;
        while (true) {
            int num = list.get(index++);
            if (n <= num) {
                index = index - 1;
                if (index % 2 == 1) {
                    startIndex = list.get(index - 1) + 1;
                    int top = index;
                    int bottom = 1;
                    for (int i = startIndex; i <= list.get(index); i++) {
                        if (i == n) {
                            System.out.println(top + "/" + bottom);
                            break;
                        } else {
                            top--;
                            bottom++;
                        }
                    }
                    break;
                } else if (index % 2 == 0) {
                    startIndex = list.get(index - 1) + 1;
                    int top = 1;
                    int bottom = index;
                    for (int i = startIndex; i <= list.get(index); i++) {
                        if (i == n) {
                            System.out.println(top + "/" + bottom);
                            break;
                        } else {
                            top++;
                            bottom--;
                        }
                    }
                    break;
                }
            }
        }
    }

    private static void func() {
        list.add(0);
        int index = 0;
        int count = 1;
        while (true) {
            int num = list.get(index++);
            num = num + count++;
            list.add(num);
            if (num > 10000000)
                break;
        }
    }
}
