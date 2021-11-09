package baekjoon.class2;

import java.io.*;
import java.util.Stack;
import java.util.StringTokenizer;

public class Baekjoon10828 {

    public static Stack<Integer> stack = new Stack<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());

        for (int i = 0; i < n; i++) {
            String str = br.readLine();
            if (str.startsWith("push")) {
                StringTokenizer st = new StringTokenizer(str);
                st.nextToken();
                int input = Integer.parseInt(st.nextToken());
                stack.push(input);
            }
            if (str.startsWith("top")) {
                if (stack.size() == 0) {
                    bw.write("-1");
                    bw.write("\n");
                } else {
                    bw.write(String.valueOf(stack.peek()));
                    bw.write("\n");
                }
            }
            if (str.startsWith("size")) {
                bw.write(String.valueOf(stack.size()));
                bw.write("\n");
            }
            if (str.startsWith("empty")) {
                if (stack.size() == 0) {
                    bw.write("1");
                    bw.write("\n");
                } else {
                    bw.write("0");
                    bw.write("\n");
                }
            }
            if (str.startsWith("pop")) {
                if (stack.size() == 0) {
                    bw.write("-1");
                    bw.write("\n");
                } else {
                    Integer pop = stack.pop();
                    bw.write(String.valueOf(pop));
                    bw.write("\n");
                }
            }
        }
        bw.flush();
        bw.close();
        br.close();
    }
}
