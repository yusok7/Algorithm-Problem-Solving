package dongbinna.greedy;

public class Change {

	public static void main(String[] args) {
		int n = 1260;

		int[] coins = {500, 100, 50, 10};
		int result = 0;

		for (int coin : coins) {
			result += n / coin;
			n %= coin;
		}
		System.out.println(result);
	}
}
