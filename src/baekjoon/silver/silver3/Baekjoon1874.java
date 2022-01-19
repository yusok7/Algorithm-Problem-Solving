package baekjoon.silver.silver3;

import java.io.*;
import java.util.*;

public class Baekjoon1874 {
    public static Stack<Integer> stack = new Stack<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int start = 0;

        StringBuilder sb = new StringBuilder();
        while (n -- > 0) {
            int value = Integer.parseInt(br.readLine());
            if (value > start) {
                for (int i = start + 1; i <= value; i++) {
                    sb.append("+").append("\n");
                    stack.add(i);
                }
                start = value;
            } else if (stack.peek() != value) {
                System.out.println("NO");
                System.exit(0);
            }

            stack.pop();
            sb.append("-").append("\n");
        }
        System.out.println(sb.toString());
    }
}
