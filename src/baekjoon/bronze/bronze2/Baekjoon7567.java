package baekjoon.bronze.bronze2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Baekjoon7567 {

    private static Queue<String> queue = new LinkedList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        for (int i = 0; i < str.length(); i++)
            queue.add(String.valueOf(str.charAt(i)));

        int sum = 0;
        String last = "";
        int size = queue.size();
        for (int i = 0; i < size; i++) {
            String poll = queue.poll();
            if (poll.equals(last))
                sum += 5;
            else
                sum += 10;
            last = poll;
        }
        System.out.println(sum);
    }
}
