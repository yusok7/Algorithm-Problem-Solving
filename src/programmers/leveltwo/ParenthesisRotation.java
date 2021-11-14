package programmers.leveltwo;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class ParenthesisRotation {

    public static void main(String[] args) {
        String s = 	"[](){}";
        int solution = solution(s);
        System.out.println(solution);
    }

    public static int solution(String s) {
        Queue<String> queue = new LinkedList<>();
        Stack<String> stack = new Stack<>();
        String[] strArr = s.split("");
        for (String s1 : strArr) {
            queue.add(s1);
        }

        int answer = 0;
        for (int i = 0; i < queue.size(); i++) {
            for (String s1 : queue) {
                if (stack.size() == 0) stack.add(s1);
                else {
                    String peek = stack.peek();
                    if ((peek.equals("[") && s1.equals("]")) || (peek.equals("{") && s1.equals("}")) || (peek.equals("(") && s1.equals(")"))) {
                        stack.pop();
                    } else {
                        stack.add(s1);
                    }
                }
            }
            if (stack.size() == 0) answer++;
            String poll = queue.poll();
            queue.add(poll);
        }
        return answer;
    }
}
