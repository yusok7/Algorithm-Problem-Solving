package programmers.kakao;

import java.util.*;

public class FailRate {

    static class Node implements Comparable<Node> {

        int stage;
        double rate;

        public Node(int stage, double rate) {
            this.stage = stage;
            this.rate = rate;
        }

        public int getStage() {
            return stage;
        }

        @Override
        public int compareTo(Node other) {
            if (this.rate == other.rate) {
                return Integer.compare(this.stage, other.stage);
            }
            return Double.compare(other.rate, this.rate);
        }
    }

    public static void main(String[] args) {
        int n = 5;
        int[] stages = {4,4,4,4,4};
        int[] solution = solution(n, stages);
        for (int i : solution) {
            System.out.println("i = " + i);

        }
    }

    public static int[] solution(int N, int[] stages) {
        int[] answer = new int[N];
        List<Node> list = new ArrayList<>();

        int[] arr1 = new int[N + 1];
        for (int val : stages) {
            if (val > N) {
                for (int i = 0; i <= N; i++) {
                    arr1[i] += 1;
                }
            } else {
                for (int i = 0; i <= val; i++) {
                    arr1[i] += 1;
                }
            }
        }
        int[] arr2 = new int[N + 1];
        for (int val : stages) {
            if (val > N) continue;
            else {
                arr2[val] += 1;
            }
        }

        for (int i = 1; i <= N; i++) {
            int stage = i;
            double rate = (double)arr2[i] / arr1[i];
            if (arr2[i] == 0 && arr1[i] == 0) {
                rate = 0.0;
            }
            list.add(new Node(stage, rate));
        }

        Collections.sort(list);
        for (int i = 0; i < N; i++) {
            answer[i] = list.get(i).getStage();
        }

        return answer;
    }
}
