package baekjoon.bronze.bronze3;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Baekjoon1009 {

    public static void main(String[] args) throws Exception {
        List<Integer> list = new ArrayList<>();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            list.add(a % 10);

            int count = 2;
            while (true) {
                long num = (long)Math.pow(a, count++);
                num = num % 10;

                if (list.contains(Integer.parseInt(String.valueOf(num))))
                    break;
                else
                    list.add(Integer.parseInt(String.valueOf(num)));
            }

            int size = list.size();
            int index = b % size - 1;
            if (index < 0)
                index = list.size() - 1;
            int result = list.get(index);
            if (result == 0)
                result = 10;
            System.out.println(result);
            list.clear();
        }
    }
}
