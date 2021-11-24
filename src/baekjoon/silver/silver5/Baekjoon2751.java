package baekjoon.silver.silver5;

import java.io.*;
import java.util.PriorityQueue;

public class Baekjoon2751 {

    public static PriorityQueue<Integer> pq = new PriorityQueue<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());

        for (int i = 0; i < n; i++) {
            int input = Integer.parseInt(br.readLine());
            pq.add(input);
        }

        for (int i = 0; i < n; i++) {
            bw.write(String.valueOf(pq.poll()));
            bw.write("\n");
        }

        br.close();
        bw.flush();
        bw.close();
    }
}
