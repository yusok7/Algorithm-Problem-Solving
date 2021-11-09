package programmers.leveltwo;

import java.util.ArrayList;

public class FunctionDevelopment {
	public static void main(String[] args) {
		int[] progresses = {95, 90, 99, 99, 80, 99};
		int[] speeds = {1, 1, 1, 1, 1, 1};
		int[] solution = solution(progresses, speeds);
		for (int i : solution) {
			System.out.println("i = " + i);
		}
	}

	public static int[] solution(int[] progresses, int[] speeds) {

		int count = 0;

		ArrayList<Integer> list = new ArrayList<>();
		ArrayList<Integer> speed = new ArrayList<>();
		ArrayList<Integer> result = new ArrayList<>();

		// 진행 상황 리스트로
		for (int i = 0; i < progresses.length; i++) {
			list.add(progresses[i]);
		}

		for (int i = 0 ; i< speeds.length; i++) {
			speed.add(speeds[i]);
		}

		// 리스트의 요소가 모두 사라질때 까지
		while (!list.isEmpty()) {
			// 진행상황에 speed 더해주기
			for (int j = 0; j < list.size(); j++) {
				list.set(j, list.get(j) + speed.get(j));
			}

			// 첫번째 우선순위의 값이 100이 넘어갔을때
			if (list.get(0) >= 100) {
				while (!list.isEmpty()) {
					list.remove(0);
					speed.remove(0);
					count++;
					if (list.size()>0) {
						if (list.get(0) >= 100) {
							continue;
						} else {
							break;
						}
					}
				}
			}
			if (count!=0) {
				result.add(count);
			}
			count = 0;
		}

		int[] answer = new int[result.size()];

		for (int i = 0; i<result.size();i++){
			answer[i] = result.get(i);
		}

		return answer;
	}
}
