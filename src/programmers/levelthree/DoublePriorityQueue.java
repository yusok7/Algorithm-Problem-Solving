package programmers.levelthree;

import java.util.Comparator;
import java.util.PriorityQueue;

public class DoublePriorityQueue {

    public static void main(String[] args) {
        String[] operations = {"I 16","D 1"};
        solution(operations);
    }

    public static int[] solution(String[] operations) {
        int[] answer = new int[2];
        // 최대힙
        PriorityQueue<Integer> pq1 = new PriorityQueue<>(Comparator.reverseOrder());
        // 최소힙
        PriorityQueue<Integer> pq2 = new PriorityQueue<>();

        for (String val : operations) {
            if (val.startsWith("I")) {
                String[] strArr = val.split(" ");
                pq1.add(Integer.parseInt(strArr[1]));
                pq2.add(Integer.parseInt(strArr[1]));
            } else if (val.equals("D -1")) { // 최솟값 삭제
                Integer min = pq2.peek();
                pq2.remove(min);
                pq1.remove(min);
            } else {
                Integer max = pq1.peek();
                pq1.remove(max);
                pq2.remove(max);
            }
        }
        if (pq1.isEmpty()) {
            answer[0] = answer[1] = 0;
        } else {
            answer[0] = pq1.poll();
            answer[1] = pq2.poll();
        }
        return answer;
    }
}

