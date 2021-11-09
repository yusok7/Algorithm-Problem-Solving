package programmers.levelone;

import java.util.ArrayList;
import java.util.Locale;

/**
 * 아직 못 풀음..
 */
public class RecommendNewId {
	public static void main(String[] args) {

		String a= "...!@BaT#*..y.abcdefghijklm";
		String b="z-+.^.";
		String c="=.=";
		String d="123_.def";
		String e="abcdefghijklmn.p";

		String solution = solution(a);
		System.out.println("solution = " + solution);
	}

	public static String solution(String new_id) {

		String answer = "";

		char[] arr = {'~', '!', '@', '#', '$', '%', '^', '&', '*', '(', ')', '=', '+', '[', '{', ']', '}', ':', '?',
			'<', '>', '/'};

		// 소문자로 변경
		new_id = new_id.toLowerCase(Locale.ROOT);

		// 문자열을 list에 담으면서 포함하면 안되는 문자가 있는지 확인
		String[] split = new_id.split("");
		int length = split.length;
		ArrayList<String> list = new ArrayList<>();

		// split
		for (int i = 0; i < length; i++) {
			//
			for (int j = 0; j < arr.length; j++) {
				if (split[i].equals(arr[j])) {
					break;
				}
			}
			list.add(split[i]);
		}

		ArrayList<Integer> delete = new ArrayList<>();
		// 연속된 마침표 하나로 제거
		for (int k = 0; k < list.size(); k++) {
			if (list.get(k).equals(".") && list.get(k + 1).equals(".") && k < list.size() - 1) {
				delete.add(k + 1);
			}
		}

		for (int l = 0; l < delete.size(); l++) {
			int count = 0;
			list.remove(delete.get(l)-count);
			count ++;
		}

		if (list.get(0).equals(".")) {
			list.remove(0);
		}
		int size = list.size();
		if (list.get(size-1).equals(".")) {
			list.remove(size-1);
		}

		if (list.size() == 0) {
			list.add("a");
		}

		if(list.size()>=16) {
			for(int a = 15; a<list.size();a++) {
				list.remove(a);
			}
			if(list.get(14).equals(".")) {
				list.remove(14);
			}
		}

		if (list.size() ==1){
			list.add(list.get(0));
			list.add(list.get(0));
		}
		if(list.size()==2){
			list.add(list.get(1));
		}

		for (int b=0; b<list.size();b++) {
			answer +=list.get(b);
		}

		return answer;
	}
}
