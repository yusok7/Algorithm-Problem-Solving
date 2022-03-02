package algorithm.eratosthenes;

public class Prime {

    // 120까지의 소수 구하기
    public static boolean[] prime = new boolean[10000001];

    public static void main(String[] args) {

        // 구하고자 하는 숫자 범위
        int n = 10000000;

        // 0과 1은 소수가 아니므로 제외
        prime[0] = prime[1] = true;

        for (int i = 2; i*i <= n; i++) {
            if (!prime[i]) {
                for (int j = i*i; j <= n; j += i) {
                    prime[j] = true;
                }
            }
        }

        for (int i = 0; i <= n; i++) {
            if (!prime[i]) System.out.println(i);
        }
    }
}
