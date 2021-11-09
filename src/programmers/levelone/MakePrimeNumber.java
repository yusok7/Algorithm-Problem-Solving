package programmers.levelone;

import java.util.ArrayList;
import java.util.List;

public class MakePrimeNumber {
    public static boolean[] prime = new boolean[50001];
    public static List<Integer> primeNumbers = new ArrayList<>();
    public static List<int[]> list = new ArrayList<>();
    public static List<Integer> result = new ArrayList<>();
    public static int[] arr;
    public static int n;
    public static int m;

    public static void main(String[] args) {
        int[] nums = {1,2,3,4};
        int solution = solution(nums);
        System.out.println(solution);
    }

    public static int solution(int[] nums) {
        int answer = 0;
        isPrime();
        n = nums.length;
        m = 3;
        arr = new int[m];
        comb(0,n,0);

        for (int[] val : list) {
            int sum = 0;
            for (int var : val) {
                sum += nums[var];
            }
            result.add(sum);
        }

        for (Integer val : result) {
            if (primeNumbers.contains(val)) {
                answer++;
            }
        }

        return answer;
    }

    public static void isPrime() {
        prime[0] = prime[1] = true;
        int n = 50000;

        for (int i = 2; i*i <= n; i++) {
            if (!prime[i]) {
                for (int j = i*i; j <=n; j+=i) {
                    prime[j] = true;
                }
            }
        }

        for (int i = 0; i <=n; i++) {
            if(!prime[i]) {
                primeNumbers.add(i);
            }
        }
    }

    public static void comb(int at, int n, int depth) {
        if (depth == 3) {
            int[] output = new int[3];
            for (int i = 0; i < 3; i++) {
                output[i] = arr[i];
            }
            list.add(output);
            return;
        }
        for (int i = at; i < n; i++) {
            arr[depth] = i;
            comb(i+1, n, depth+1);
        }
    }
}
