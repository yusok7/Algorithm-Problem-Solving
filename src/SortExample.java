import java.util.Arrays;
import java.util.Comparator;

public class SortExample {
	public static void main(String[] args) {

		int [][] arr = new int[3][2];

		arr = new int[][] {{2121112, 2}, {3, 4}, {0, 1}};

		Arrays.sort(arr,(int[] e1, int[] e2)->{
			return e1[0] - e2[0];
		});

		for (int[] ints : arr) {
			System.out.println("ints[0] = " + ints[0]);
			System.out.println("ints[0] = " + ints[1]);
		}

		String[] arr2 = new String[3];
		arr2= new String[] {"abc", "kkk", "def"};

		Arrays.sort(arr2, (String a1, String a2) ->{
			return a1.compareTo(a2);
		});

		for (String s : arr2) {
			System.out.println("s = " + s);
		}

		Arrays.sort(arr2, new Comparator<String>() {
			public int compare(String s1, String s2) {
				// 단어 길이가 같을 경우
				if (s1.length() == s2.length()) {
					return s1.compareTo(s2);
				}
				// 그 외의 경우
				else {
					return s1.length() - s2.length();
				}
			}
		});

	}
}
