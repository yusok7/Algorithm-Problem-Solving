package programmers.leveltwo;

import java.util.LinkedList;
import java.util.Queue;

public class Printer {

    public Queue<Boolean> locationQueue = new LinkedList<>();
    public Queue<Integer> priorityQueue = new LinkedList<>();

    public int solution(int[] priorities, int location) {
        int answer = 1;
        for (int val : priorities) {
            priorityQueue.add(val);
        }
        for (int i = 0; i < priorities.length; i++) {
            if (i == location) {
                locationQueue.add(true);
            } else {
                locationQueue.add(false);
            }
        }

        while (true) {
            Integer priority = priorityQueue.poll();
            boolean bool = true;
            for (Integer val : priorityQueue) {
                if (val > priority) { // 뒤에 우선순위가 더 큰 것이 있다면
                    bool = false;
                    break;
                }
            }
            if (!bool) { // 뒤에 우선순위가 더 큰 것이 있다면
                priorityQueue.add(priority);
                Boolean bool2 = locationQueue.poll();
                locationQueue.add(bool2);
            } else {
                if (locationQueue.poll() == true) {
                    break;
                }
                answer++;
            }
        }
        return answer;
    }
}
