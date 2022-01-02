package baekjoon.silver.silver5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class Baekjoon2751 {

    public static PriorityQueue<Integer> queue = new PriorityQueue<>();
    public static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        for (int i = 0; i < n; i++) {
            int num = Integer.parseInt(br.readLine());
            queue.add(num);
        }

        for (int i = 0; i < n; i++) {
            sb.append(queue.poll()).append("\n");
        }
        System.out.println(sb.toString());
    }
}
