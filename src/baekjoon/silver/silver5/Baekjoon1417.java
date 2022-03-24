package baekjoon.silver.silver5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Baekjoon1417 {

    private static List<Integer> list = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        if (n == 1) {
            br.readLine();
            System.out.println(0);
            System.exit(0);
        }

        int num = Integer.parseInt(br.readLine());

        for (int i = 0; i < n - 1; i++)
            list.add(Integer.parseInt(br.readLine()));

        int answer = 0;
        while (true) {
            Collections.sort(list, Collections.reverseOrder());
            if (num > list.get(0))
                break;
            answer++;
            num++;
            list.set(0, list.get(0) - 1);
        }
        System.out.println(answer);
    }
}
