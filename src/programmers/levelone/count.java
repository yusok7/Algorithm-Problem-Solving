package programmers.levelone;

public class count {
	public static void main(String[] args) {
		int result = 0;

		int count = 0;

		int left = 13;
		int right = 17;
		int[] arr = new int[right - left + 1];

		for (int i = 0; i <= right - left; i++) {
			arr[i] = left +i;
		}

		for (int i : arr) {
			for (int j = 1 ; j<=i; j++) {
				if ( i % j == 0) {
					count ++;
				}
			}
			if (count %2==0) {
				result +=i;
			} else{
				result -=i;
			}
			count = 0;
		}

		System.out.println(result);
	}
}
