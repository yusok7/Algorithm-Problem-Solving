package baekjoon.silver.silver4;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Baekjoon18258 {

    public static LinkedList<Integer> queue = new LinkedList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String str = st.nextToken();
            if (str.equals("push")) {
                int num = Integer.parseInt(st.nextToken());
                queue.add(num);
            } else if (str.equals("size")){
                bw.write(String.valueOf(queue.size()));
                bw.write("\n");
            } else if (str.equals("empty")) {
                if (queue.size() == 0) {
                    bw.write("1");
                    bw.write("\n");
                }
                else {
                    bw.write(String.valueOf(0));
                    bw.write("\n");
                }
            } else if (str.equals("pop")) {
                if (queue.size() != 0) {
                    bw.write(String.valueOf(queue.poll()));
                    bw.write("\n");
                } else {
                    bw.write(String.valueOf(-1));
                    bw.write("\n");
                }
            } else if (str.equals("front")) {
                if (queue.size() != 0) {
                    bw.write(String.valueOf(queue.peek()));
                    bw.write("\n");
                } else {
                    bw.write(String.valueOf(-1));
                    bw.write("\n");
                }
            } else if (str.equals("back")) {
                if (queue.size() != 0) {
                    bw.write(String.valueOf(queue.peekLast()));
                    bw.write("\n");
                } else {
                    bw.write(String.valueOf(-1));
                    bw.write("\n");
                }
            }
        }
        bw.flush();
        bw.close();
        br.close();
    }
}
