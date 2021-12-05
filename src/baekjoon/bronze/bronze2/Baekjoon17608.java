package baekjoon.bronze.bronze2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Baekjoon17608 {

    public static Stack<Integer> stack = new Stack<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        for (int i = 0; i < n; i++) {
            int input = Integer.parseInt(br.readLine());
            stack.add(input);
        }

        int max = 0;
        int count = 0;

        for (int i = 0; i < n; i++) {
            int pop = stack.pop();
            if (pop > max) {
                max = pop;
                count++;
            }
        }

        System.out.println(count);
    }
}
