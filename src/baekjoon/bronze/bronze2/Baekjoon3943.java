package baekjoon.bronze.bronze2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Baekjoon3943 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        List<Integer> list = new ArrayList<>();
        List<Integer> max = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            list.clear();
            int num = Integer.parseInt(br.readLine());
            if (num == 1) {
                max.add(1);
                continue;
            }

            list.add(num);
            while (true){
                if (num % 2 == 0) {
                    num = num / 2;
                    list.add(num);
                } else {
                    num = num * 3 + 1;
                    list.add(num);
                }
                if (num == 1)
                    break;
            }
            max.add(Collections.max(list));
        }
        for (Integer integer : max) {
            System.out.println(integer);
        }
    }
}
