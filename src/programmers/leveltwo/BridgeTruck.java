package programmers.leveltwo;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class BridgeTruck {

	// 트럭의 무게와, 다리위에서 있는 시간을 표현하는 time을 클래스로 생성
	static class Truck {

		int weight;
		int time;

		public Truck(int weight, int time) {
			this.weight = weight;
			this.time = time;
		}
	}

	public static void main(String[] args) {
		int bridge_length = 100;
		int weight = 100;
		int[] truck_weights = {10, 10, 10, 10, 10, 10, 10, 10, 10, 10};

		int solution = solution(bridge_length, weight, truck_weights);
		System.out.println("solution = " + solution);
	}

	public static int solution(int bridge_length, int weight, int[] truck_weights) {

		// 시간
		int count = 0;
		// 다리위에 있는 트럭들의 무게 합
		int weightSum = 0;
		// 최종 정답
		int answer = 0;

		// 다리위에 있는 트럭들의 리스트 생성
		ArrayList<Truck> bridge = new ArrayList<>();

		// 현재 대기중인 트럭들 큐에 담아주기
		Queue<Truck> queue = new LinkedList<>();
		for (int i = 0; i < truck_weights.length; i++) {
			queue.add(new Truck(truck_weights[i], 0));
		}

		while (true) {

			// 무조건 1초부터 트럭이 다리에 올라갈 수 있으므로 처음부터 1초 증가
			count++;

			// 다리에 트럭이 올라갈 수 있는지 검사
			while (true) {

				// 큐의 맨 앞에 있는 트럭 꺼내오기 (삭제x)
				Truck peek = queue.peek();
				if (peek == null) {
					break;
				}

				for (Truck truck : bridge) {
					// 다리에 올라가 있는 트럭들의 총 무게계산. 다리위에 트럭이 없다면 그냥 넘어감
					weightSum += truck.weight;
				}

				// 현재 다리에 올라가있는 트럭들의 총 무게 + 큐 제일 앞에 있는 트럭의 무게
				if (weightSum + peek.weight <= weight) {
					// 트럭이 다리에 올라갈 수 있다면은 큐에서 꺼내주기 (삭제 o)
					Truck poll = queue.poll();
					bridge.add(poll);
					// 1초에 하나의 트럭만 올라갈 수 있음. 하나의 트럭이 올라갔다면 더 이상 검사하지 않고 break;
					break;
				} else {
					break;
				}
			}

			// 다리위에 있는 트럭들 시간 증가
			for (Truck truck : bridge) {
				truck.time += 1;
			}

			// queue에 들어있는 Truck 클래스의 time이 bridge_length랑 같으면 제거
			for (int i = 0; i < bridge.size(); i++) {
				if (bridge.get(i).time == bridge_length) {
					bridge.remove(i);
				}
			}

			if (bridge.size() == 0 && queue.size() == 0) {
				break;
			}
			weightSum = 0;
		}

		answer = count;
		return answer + 1;
	}
}
