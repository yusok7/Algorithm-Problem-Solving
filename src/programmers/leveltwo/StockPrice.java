package programmers.leveltwo;

import java.util.ArrayList;
import java.util.List;

/**
 * https://programmers.co.kr/learn/courses/30/lessons/42584
 */

public class StockPrice {

    public static void main(String[] args) {
        int[] prices = {1,2,3,2,3};
        int[] solution = solution(prices);
        for (int i : solution) {
            System.out.println(i);
        }
    }

    public static int[] solution(int[] prices) {
        List<Integer> result = new ArrayList<>();

        List<Integer> price = new ArrayList<>();
        for (int i = 0; i < prices.length; i++) {
            price.add(prices[i]);
        }

        for (int i = 0; i < price.size(); i++) {
            int num = price.get(i);
            int count = 0;
            if (i == price.size() -1) {
                result.add(0);
                break;
            }

            int j;
            for (j = i + 1; j < price.size(); j++) {
                if (num <= price.get(j)) {
                    count++;
                } else {
                    count++;
                    result.add(count);
                    break;
                }
            }

            if (j == price.size()) {
                result.add(count);
            }
        }

        int[] answer = new int[prices.length];

        for (int i = 0; i < result.size(); i++) {
            answer[i] = result.get(i);
        }
        return answer;
    }
}
