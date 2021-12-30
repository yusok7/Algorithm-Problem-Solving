package baekjoon.silver.silver4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Baekjoon4949 {

    public static Stack<String> stack = new Stack<>();
    public static List<String> list = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        while (true) {
            String str = br.readLine();
            if (str.equals(".")) break;

            boolean bool = false;
            String[] strArr = str.split("");
            list.clear();
            for (String val : strArr) {
                if (val.equals("(") || val.equals(")") || val.equals("[") || val.equals("]")) {
                    list.add(val);
                }
            }
            for (String val : list) {
                // 1. 여는 괄호가 나온다면 스택에 추가
                if (val.equals("(") || val.equals("[")) {
                    stack.add(val);
                } else { // 2. 닫는 괄호가 나왔을 경우
                    // 2-1 스택이 비어있으면 올바르지 않은 괄호 쌍
                    if (stack.size() == 0) {
                        bool = true;
                        break;
                    }

                    if (val.equals(")")) {
                        String peek = stack.peek();
                        if (peek.equals("(")) {
                            stack.pop();
                            continue;
                        } else {
                            bool = true;
                            break;
                        }
                    }

                    if (val.equals("]")) {
                        String peek = stack.peek();
                        if (peek.equals("[")) {
                            stack.pop();
                            continue;
                        } else {
                            bool = true;
                            break;
                        }
                    }
                }
            }

            if (bool || stack.size() != 0) {
                System.out.println("no");
            } else {
                System.out.println("yes");
            }

            // 스택 초기화
            stack.clear();
        }
    }
}
