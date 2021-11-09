package baekjoon.silver.silver1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Baekjoon1697 {

    public static Queue<Integer> queue = new LinkedList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int count = 0;

        queue.add(n);
        while (true) {
            List<Integer> list = new ArrayList<>();
            for (Integer var : queue) {
                if (var == k) {
                    System.out.println(count);
                    System.exit(0);
                } else {
                    list.add(var);
                }
            }

            count++;

            for (Integer var : list) {
                queue.add(var-1);
                queue.add(var+1);
                queue.add(2*var);
            }
        }
    }
}
