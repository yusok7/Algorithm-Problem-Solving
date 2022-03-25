package baekjoon.bronze.bronze2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Baekjoon2292 {

    private static List<Integer> list = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        func();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.parseInt(br.readLine());
        int answer = 0;

        for (int i = 0; i < list.size(); i++) {
            Integer listNum = list.get(i);
            if (num <= listNum) {
                answer = i;
                break;
            }
        }
        System.out.println(answer);
    }

    private static void func() {
        list.add(0);
        list.add(1);
        int index = 2;
        int count = 6;
        while (true) {
            list.add(list.get(index - 1) + count);
            if (list.get(index++) >= 1000000000)
                break;
            count += 6;
        }
    }
}
