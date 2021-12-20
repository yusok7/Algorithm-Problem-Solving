package programmers.leveltwo;

import java.util.*;

public class TargetNumber {

    class Node {
        int value;
        int index;

        public Node(int value, int index) {
            this.value = value;
            this.index = index;
        }

        public int getValue() {
            return value;
        }

        public int getIndex() {
            return index;
        }
    }

    public Queue<Node> queue = new LinkedList<>();

    public int solution(int[] numbers, int target) {
        int answer = 0;
        int length = numbers.length; // 5
        queue.add(new Node(numbers[0], 0));
        queue.add(new Node(-1 * (numbers[0]), 0));
        while(!queue.isEmpty()) {
            Node node = queue.poll();
            if (node.getIndex() == length - 1 && node.getValue() != target) {
                continue;
            }
            if (node.getIndex() == length - 1 && node.getValue() == target) {
                answer++;
            } else if (node.getIndex() != length) {
                int value = node.getValue(); // 1 혹은 -1
                int index = node.getIndex(); // 현재 0번 인덱스
                queue.add(new Node(value + numbers[index + 1], index + 1));
                queue.add(new Node(value - (numbers[index + 1]), index + 1));
            }
        }
        return answer;
    }
}
