package programmers.levelone;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class RemoveSmallNumber {
	public static void main(String[] args) {
		int[] arr = {4,3,2,1};
		solution(arr);
	}
	public static int[] solution(int[] arr) {

		ArrayList<Integer> list = new ArrayList<>();
		int[] answer = {};
		int[] result = new int[1];

		if (arr.length == 1) {
			result[0] = -1;
			return result;
		}

		for (int i = 0; i < arr.length; i++) {
			list.add(arr[i]);
		}

		int min = Collections.min(list);
		int index = list.indexOf(min);
		list.remove(index);

		int[] result2 = new int[list.size()];

		for (int j = 0; j < list.size(); j++) {
			result2[j] = list.get(j);
		}

		answer = result2;
		return answer;
	}
}
