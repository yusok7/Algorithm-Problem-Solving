package programmers.levelone;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class MockTest {
	public static void main(String[] args) {
		int[] answers = {1, 3, 2, 4, 2};
		int[] solution = solution(answers);
	}

	private static int[] solution(int[] answers) {

		int answersSize = answers.length;
		int count1 = 0;
		int count2 = 0;
		int count3 = 0;
		int result1 = 0;
		int result2 = 0;
		int result3 = 0;

		int[] arr1 = {1, 2, 3, 4, 5};
		int[] arr2 = {2, 1, 2, 3, 2, 4, 2, 5};
		int[] arr3 = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5};

		for (int i = 0; i < answersSize; i++) {
			if (answers[i] == arr1[count1]) {
				result1++;
			}
			if (answers[i] == arr2[count2]) {
				result2++;
			}
			if (answers[i] == arr3[count3]) {
				result3++;
			}

			count1++;
			count2++;
			count3++;

			if (count1 == 5) {
				count1 = 0;
			}
			if (count2 == 8) {
				count2 = 0;
			}
			if (count3 == 10) {
				count3 = 0;
			}
		}

		ArrayList<Integer> list = new ArrayList<>();
		list.add(result1);
		list.add(result2);
		list.add(result3);

		int max = Collections.max(list);

		list.remove(0);
		list.remove(0);
		list.remove(0);

		if (max == result1) {
			list.add(1);
		}
		if (max == result2) {
			list.add(2);
		}
		if (max == result3) {
			list.add(3);
		}

		int length = list.size();
		int answer[] = new int[length];

		for (int a = 0; a < answer.length; a++) {
			answer[a] = list.get(a);
		}

		Arrays.sort(answer);

		return answer;
	}
}
