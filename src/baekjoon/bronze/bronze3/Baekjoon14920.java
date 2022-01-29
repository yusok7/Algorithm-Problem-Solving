package baekjoon.bronze.bronze3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Baekjoon14920 {

    private static List<Integer> list = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        if (n == 1) {
            System.out.println(1);
            System.exit(0);
        }

        list.add(n);

        int index = 0;
        while (true) {
            Integer val = list.get(index);
            if (val % 2 == 1) {
                val = val * 3 + 1;
                list.add(val);
            } else {
                val = val / 2;
                list.add(val);
            }
            if (list.get(++index) == 1) {
                System.out.println(list.size());
                break;
            }
        }
    }
}
