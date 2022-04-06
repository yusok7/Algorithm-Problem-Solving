package baekjoon.silver.silver1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class Baekjoon11286 {

    private static PriorityQueue<Integer> pq = new PriorityQueue<>((Integer o1, Integer o2) -> {
        int abs1 = Math.abs(o1);
        int abs2 = Math.abs(o2);
        if (abs1 == abs2)
            return Integer.compare(o1, o2);
        return Integer.compare(abs1, abs2);
    });

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        for (int i = 0; i < n; i++) {
            int num = Integer.parseInt(br.readLine());
            if (num == 0) {
                if (pq.isEmpty()) System.out.println(0);
                else System.out.println(pq.poll());
            } else {
                pq.add(num);
            }
        }
    }
}
