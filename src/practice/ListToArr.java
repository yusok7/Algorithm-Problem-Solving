package practice;

import java.util.ArrayList;

public class ListToArr {
	public static void main(String[] args) {

		int[] arr = {};

		ArrayList<Integer> list = new ArrayList<>();
		list.add(1);
		list.add(2);

		list.set(1,3);
		arr = new int[list.size()];

		for (int j = 0; j < arr.length; j++) {
			arr[j] = list.get(j);
		}

		for (int i = 0; i < arr.length; i++) {
			System.out.println("arr[i] = " + arr[i]);
		}

	}
}
