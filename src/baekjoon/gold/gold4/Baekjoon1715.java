package baekjoon.gold.gold4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class Baekjoon1715 {

    public static PriorityQueue<Integer> pq = new PriorityQueue<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        for (int i = 0; i < n; i++) {
            int input =Integer.parseInt(br.readLine());
            pq.add(input);
        }

        int sum = 0;
        int result = 0;
        while (pq.size() != 1) {
            int num1 = pq.poll();
            int num2 = pq.poll();
            sum = num1 + num2;
            pq.add(sum);
            result += sum;
        }

        System.out.println(result);
    }
}
