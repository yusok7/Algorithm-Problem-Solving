package baekjoon.bronze.bronze2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Baekjoon1373 {

    private static Stack<Character> stack = new Stack<>();
    private static StringBuilder answer = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        for (char c : str.toCharArray())
            stack.add(c);

        while (!stack.isEmpty()) {
            StringBuilder sb = new StringBuilder();
            if (stack.size() < 3)
                break;
            for (int i = 0; i < 3; i++)
                sb.insert(0, stack.pop());
            int num = func(sb.toString());
            answer.insert(0, num);
        }

        if (stack.size() != 0) {
            StringBuilder sb = new StringBuilder();
            while (!stack.isEmpty())
                sb.insert(0, stack.pop());
            while (!(sb.toString().length() == 3)) {
                sb.insert(0, 0);
            }
            int num = func(sb.toString());
            answer.insert(0, num);
        }
        System.out.println(answer.toString());
    }

    private static int func(String str) {
        int result = 0;
        result += 4 * (str.charAt(0) - '0');
        result += 2 * (str.charAt(1) - '0');
        result += 1 * (str.charAt(2) - '0');
        return result;
    }
}
