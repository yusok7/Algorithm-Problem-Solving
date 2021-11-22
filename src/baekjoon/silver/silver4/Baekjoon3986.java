package baekjoon.silver.silver4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Baekjoon3986 {

    public static Stack<String> stack = new Stack<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int answer = 0;
        for (int i = 0; i < n; i++) {
            String str = br.readLine();
            String[] strArr = str.split("");
            for (int j = 0; j < strArr.length; j++) {
                if (stack.size() == 0) stack.add(strArr[j]);
                else {
                    String peek = stack.peek();
                    if (peek.equals(strArr[j])) {
                        stack.pop();
                    } else {
                        stack.add(strArr[j]);
                    }
                }
            }
            if (stack.size() == 0) answer++;
            stack.clear();
        }
        System.out.println(answer);
    }
}
