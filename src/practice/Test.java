package practice;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Locale;
import java.util.Map;
import java.util.Set;

public class Test {
	public static void main(String[] args) {
		String str = "hi";
		String s = str.toUpperCase();
		System.out.println("s = " + s);

		char[] charArr = {'a','b','c'};

		char[] charArr2 = new char[3];
		String[] strArr = new String[3];

		String str2 = "abc";
		charArr2 = str2.toCharArray();

		for (char c : charArr2) {
			System.out.println("c = " + c);
		}

		// for (int i=0; i<charArr.length; i++) {
		// 	strArr[i] = String.valueOf(charArr[i]);
		// }

		for (String s1 : strArr) {
			System.out.println("s1 = " + s1);
		}

		/**
		 * Arrays.sort 사용해보기
		 */

		/**
		 * 문자열
		 */
		String[] strArr2 = {"abc","def","caa"};
		Arrays.sort(strArr2, (String a1, String a2) -> {
			return a1.compareTo(a2);
		});
		for (String s1 : strArr2) {
			System.out.println("s1 = " + s1);
		}

		/**
		 * 숫자
		 */
		int[] intArr2 = {3,1,2,4,5,2,1,2,7,86,4,4,5,3,2,3,1};
		Arrays.sort(intArr2);

		int [][] arr = new int[][] {{2121112, 2}, {3, 4}, {0, 1},{0,2}};
		Arrays.sort(arr, (int[] a1, int[] a2) -> {
			if (a1[0] == a2[0]) {
				return a1[1] - a2[1];
			} else {
				return a1[0] - a2[0];
			}
		});

		for (int[] ints : arr) {
			System.out.println("ints[0] = " + ints[0]);
			System.out.println("ints[1] = " + ints[1]);
		}

		Set<Integer> hashSet = new HashSet<>();
		hashSet.add(1);
		hashSet.add(1);
		hashSet.add(2);
		for (int i = 0; i< hashSet.size(); i++) {
			for (Integer integer : hashSet) {
				System.out.println("integer = " + integer);
			}
		}
		
		Integer abc =1 ;
		int abc2;
		abc2=abc;
		System.out.println("abc = " + abc2);

		Map<String, Integer> hashMap = new HashMap<>();
		hashMap.put("1",123);
		hashMap.put("2",123);
		if (hashMap.containsValue(123)) {
			System.out.println("hi");
		}
		Set<String> strings = hashMap.keySet();

		String[] arr3 = {"abcde","cdefg","bcde"};
		Arrays.sort(arr3);
		for (String s1 : arr3) {
			System.out.println("s1 = " + s1);
		}
	}
}
