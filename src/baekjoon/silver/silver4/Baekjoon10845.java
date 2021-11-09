package baekjoon.silver.silver4;

import java.io.*;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Baekjoon10845 {

    public static LinkedList<Integer> queue = new LinkedList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());

        for (int i = 0; i < n; i++) {
            String str = br.readLine();
            if (str.startsWith("push")) {
                StringTokenizer st = new StringTokenizer(str, " ");
                st.nextToken();
                int input = Integer.parseInt(st.nextToken());
                queue.add(input);
            }
            if (str.startsWith("pop")) {
                if (queue.isEmpty()) {
                    bw.write("-1");
                    bw.write("\n");
                } else {
                    Integer poll = queue.poll();
                    bw.write(String.valueOf(poll));
                    bw.write("\n");
                }
            }
            if (str.startsWith("size")) {
                bw.write(String.valueOf(queue.size()));
                bw.write("\n");
            }
            if (str.startsWith("empty")) {
                if (queue.isEmpty()) {
                    bw.write("1");
                    bw.write("\n");
                } else {
                    bw.write("0");
                    bw.write("\n");
                }
            }
            if (str.startsWith("front")) {
                if (queue.isEmpty()) {
                    bw.write("-1");
                    bw.write("\n");
                } else {
                    bw.write(String.valueOf(queue.peek()));
                    bw.write("\n");
                }
            }
            if (str.startsWith("back")) {
                if (queue.isEmpty()) {
                    bw.write("-1");
                    bw.write("\n");
                } else {
                    bw.write(String.valueOf(queue.peekLast()));
                    bw.write("\n");
                }
            }
        }
        bw.flush();
        bw.close();
        br.close();

    }
}
