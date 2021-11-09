package programmers.levelone;

public class WeeklyChallengeFirstWeek {
	public static void main(String[] args) {

	}

	public long solution(int price, int money, int count) {

		long result = 0;
		long answer = -1;

		for (int i = 0; i < count; i++) {
			result += price * (i + 1);
		}

		answer = result - money;
		if (answer <0) {
			answer = 0;
		}

		return answer;
	}
}
