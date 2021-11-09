package practice;

import java.util.ArrayList;
import java.util.List;

public class CombinationBackTracking {

	public static void main(String[] args) {

		int[] arr = {1, 2, 3}; //조합을 만들 배열
		boolean[] visited = new boolean[arr.length];

		//1. 백트래킹을 이용해 구현
		System.out.println("-------- 1. 백트래킹 ---------");
		//
		// for(int r = 1; r <= arr.length; r++) {
		// 	System.out.println("\n" + arr.length + "개 중에 " + r  + "개 뽑음");
		// 	comb1(arr, visited, 0, r);
		// }

		System.out.println("custom");
		comb1(arr, visited, 0, 2);
	}

	//1. 백트래킹을 이용해 구현
	static void comb1(int[] arr, boolean[] visited, int start, int r) {
		if(r == 0) {
			print(arr, visited);
			return;
		} else {
			for(int i = start; i < arr.length; i++) {
				visited[i] = true;
				comb1(arr, visited, i + 1, r - 1);
				visited[i] = false;
			}
		}
	}

	// 배열 출력
	static void print(int[] arr, boolean[] visited) {
		List<String> list = new ArrayList<>();
		String str = "";
		for(int i = 0; i < arr.length; i++) {
			if(visited[i] == true) {
				str += String.valueOf(arr[i]);
			}
		}
		list.add(str);
		System.out.println();
	}
}
