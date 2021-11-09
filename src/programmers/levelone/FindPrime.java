package programmers.levelone;

import java.util.HashMap;
import java.util.Map;

public class FindPrime {

    public static boolean[] prime = new boolean[1000001];
    public static Map<Integer,Integer> map = new HashMap<>();

    public static int solution(int n) {
        int answer = 0;
        isPrime();
        for (int i = 0; i <= n; i++) {
            if (map.containsKey(i)) {
                answer++;
            }
        }
        return answer;
    }

    public static void isPrime() {
        int n = 1000000;
        prime[0] = prime[1] = true;

        for (int i = 2; i*i <= n; i++) {
            if (!prime[i]) {
                for (int j = i*i; j <= n; j+=i) {
                    prime[j] = true;
                }
            }
        }

        for (int i = 0; i <= n; i++) {
            if (!prime[i]) {
                map.put(i,i);
            }
        }

    }
}
