package programmers.levelone;

import java.util.ArrayList;

public class UnsuccessfulRunner {
	public static void main(String[] args) {

	}

	public String solution(String[] participant, String[] completion) {
		int participantSize = participant.length;
		int completionSize = completion.length;

		String answer="";

		ArrayList<String> list1 = new ArrayList<>();
		ArrayList<String> list2 = new ArrayList<>();
		
		for (int i = 0; i < participantSize; i++) {
			list1.add(participant[i]);
		}

		for (int j = 0; j < completionSize; j++) {
			list2.add(completion[j]);
		}

		for (int k=0; k<completionSize; k++){
			if (list2.contains(list1.get(k))) {
				list2.remove(list1.get(k));
			} else {
				answer = list1.get(k);
				break;
			}
		}
		return answer;
	}
}
