package programmers.levelone;

import java.awt.geom.Ellipse2D;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Knumber {

    public int[] solution(int[] array, int[][] commands) {

        List<Integer> result = new ArrayList<>();

        for (int[] command : commands) {

            List<Integer> list = new ArrayList<>();

            int i = command[0];
            int j = command[1];
            int k = command[2];
            for (int index = i-1; index < j; index++) {
                list.add(array[index]);
            }
            Collections.sort(list);
            Integer integer = list.get(k - 1);
            result.add(integer);
        }

        int[] answer = new int[result.size()];
        for (int i = 0; i < result.size(); i++) {
            answer[i] = result.get(i);
        }
        return answer;
    }
}
