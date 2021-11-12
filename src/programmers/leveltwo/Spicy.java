package programmers.leveltwo;

import java.util.PriorityQueue;

public class Spicy {

    public int solution(int[] scoville, int K) {
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        for (int val : scoville) {
            queue.add(val);
        }

        int count = 0;
        while(true) {
            if (queue.size() > 1) {
                Integer peek = queue.peek();
                if (peek >= K) return count;
                int a = queue.poll();
                int b = queue.poll();
                count++;
                queue.add(a+(b*2));
            } else if (queue.size()==1 && queue.peek() >= K) {
                return count;
            } else {
                return -1;
            }
        }
    }
}
