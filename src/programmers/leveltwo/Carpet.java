package programmers.leveltwo;

import java.util.LinkedList;
import java.util.Queue;

public class Carpet {

    public Queue<Integer> queue = new LinkedList<>();
    public int[] solution(int brown, int yellow) {
        int[] answer = new int[2];
        int width = 0;
        int height = 0;
        for (int i = 1; i <= yellow; i++) {
            if (yellow % i == 0) {
                queue.add(i);
            }
        }
        while (true) {
            width = queue.poll();
            height = yellow / width;
            if (width < height) continue;
            int result = width * 2 + height * 2 + 4;
            if (result == brown) {
                answer[0] = width + 2;
                answer[1] = height + 2;
                break;
            }
        }
        return answer;
    }
}
