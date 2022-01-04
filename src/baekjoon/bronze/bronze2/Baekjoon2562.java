package baekjoon.bronze.bronze2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Baekjoon2562 {

    public static void main(String[] args) throws IOException {
        List<Integer> list = new ArrayList<>();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for (int i = 0; i < 9; i++) {
            int num = Integer.parseInt(br.readLine());
            list.add(num);
        }

        int max = Collections.max(list);
        System.out.println(max);
        System.out.println(list.indexOf(max) + 1);
    }
}
