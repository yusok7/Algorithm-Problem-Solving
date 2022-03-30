package programmers.leveltwo;

import java.util.Arrays;

public class HIndex {
    public int solution(int[] citations) {
        Arrays.sort(citations);
        int answer = 0;
        int length = citations.length;
        for (int i = 0; i < 10001; i++) {
            int num = i;
            int idx = func(citations, i);
            if (length - idx >= num)
                answer = num;
            else
                break;
        }
        return answer;
    }

    private int func(int[] arr, int k) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] >= k)
                return i;
        }
        return arr.length;
    }
}
