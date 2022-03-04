package algorithm.eratosthenes;

/**
 * Java에 내장되어 있는 Math.sqrt()함수를 통해서 2부터 루트 n까지의 범위에서 소수를 체크판별 할 수 있다.
 * 범위가 2부터 루트 n까지인 이유는 소수는 1과 자기 자신으로만 나누어지는 숫자이기 때문이다.
 */

public class IsPrime {

    public static void main(String[] args) {
        int n = 13;
        boolean prime = isPrime(n);
        System.out.println(prime);
    }

    private static boolean isPrime(int n) {
        for (int i = 2; i <= (int)Math.sqrt(n); i++) {
            if (n % i == 0)
                return false;
        }
        return true;
    }
}
