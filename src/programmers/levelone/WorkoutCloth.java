package programmers.levelone;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class WorkoutCloth {
    public static void main(String[] args) {
        int n = 5;
        int[] lost = {2,4};
        int[] reserve = {1,3,5};

        int solution = solution(n, lost, reserve);
        System.out.println("solution = " + solution);
    }
    public static int solution(int n, int[] lost, int[] reserve) {

        List<Integer> losts = new ArrayList<>();
        List<Integer> reserves = new ArrayList<>();

        Arrays.sort(lost);
        Arrays.sort(reserve);

        for (int val : lost) {
            losts.add(val);
        }

        for (int val : reserve) {
            reserves.add(val);
        }

        int answer = n - lost.length;
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < reserves.size(); i++) {
            int num = reserves.get(i);
            if (losts.contains(num)) {
                reserves.set(reserves.indexOf(num), -100);
                losts.set(losts.indexOf(num), -100);
                answer++;
            }
        }

        for (Integer val : losts) {
            if (reserves.contains(val-1)) {
                int num = val-1;
                reserves.set(reserves.indexOf(num), -100);
                answer++;
                continue;
            }
            if (reserves.contains(val+1)) {
                int num = val+1;
                reserves.set(reserves.indexOf(num), -100);
                answer++;
                continue;
            }
        }
        return answer;
    }
}
