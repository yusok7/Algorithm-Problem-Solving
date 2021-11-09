package programmers.leveltwo;

import java.util.ArrayList;

public class Printer {
	public static void main(String[] args) {
		int[] priorities = {2, 1, 3, 2};
		int location = 2;
		int solution = solution(priorities, location);
		System.out.println("solution = " + solution);
	}

	public static int solution(int[] priorities, int location) {

		int length = priorities.length;
		int count = 1;
		int answer = 0;

		ArrayList<Integer> priority = new ArrayList<>();
		for (int i = 0; i < length; i++) {
			priority.add(priorities[i]);
		}

		ArrayList<String> wait = new ArrayList<>();
		for (int i = 0; i < length; i++) {
			String number = String.valueOf(i);
			wait.add("A" + number);
		}

		String goal = wait.get(location);

		while (true) {
			Integer first = priority.get(0);
			String str = wait.get(0);
			for (int i = 0; i < priority.size(); i++) {
				if (priority.get(i) > first) {
					priority.remove(0);
					priority.add(first);
					wait.remove(0);
					wait.add(str);
					break;
				}
				if (i == priority.size() - 1) {
					if (wait.get(0).equals(goal)) {
						answer = count;
						break;
					}
					priority.remove(0);
					wait.remove(0);
					count++;
				}
			}
			if (wait.get(0).equals(goal)) {

				return answer;
			}
		}
	}
}
