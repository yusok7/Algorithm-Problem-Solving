package programmers.leveltwo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LifeBoat {

    public static void main(String[] args) {
        int[] people = {70,50,80,50};
        int solution = solution(people, 100);
        System.out.println("solution = " + solution);
    }

    public static int solution(int[] people, int limit) {
        int answer = 0;
        Arrays.sort(people);

        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < people.length; i++) {
            list.add(people[i]);
        }

        int sum = 0;

        while (true) {
            int i = 0;
            int count = 0;
            for (i = 0; i < list.size(); i++) {
                sum += list.get(i);
                count++;
                if (sum > limit) break;
                if (count == 2) {
                    i++;
                    break;
                }
                if (sum <= limit) continue;

            }
            for (int j = 0; j < i; j++) {
                list.remove(0);
            }
            answer++;
            sum = 0;
            if (list.size() == 0) {
                break;
            }
        }

        return answer;
    }
}
