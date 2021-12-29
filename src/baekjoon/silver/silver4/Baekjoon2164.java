package baekjoon.silver.silver4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Baekjoon2164 {

    public static Queue<Integer> queue = new LinkedList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        for (int i = 1; i <= n; i++) {
            queue.add(i);
        }

        while (true) {
            queue.poll();
            if (queue.size() == 1) break;
            Integer poll = queue.poll();
            queue.add(poll);
        }

        System.out.println(queue.peek());
    }
}
