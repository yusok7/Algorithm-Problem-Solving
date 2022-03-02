package programmers.leveltwo;

import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;

public class FindPrime {

    public boolean[] prime;
    public Map<Integer, Integer> map;
    public Set<Integer> set;
    public int[] result;
    public boolean[] visit;

    public int solution(String numbers) {
        prime = new boolean[10000001];
        map = new HashMap<>();
        set = new LinkedHashSet<>();
        result = new int[numbers.length()];
        visit = new boolean[numbers.length()];

        int[] arr = new int[numbers.length()];

        isPrime();

        int index = 0;
        for (char c : numbers.toCharArray()) {
            int num = c - '0';
            arr[index++] = num;
        }

        dfs(0, arr.length, arr);

        int answer = 0;
        for(Integer val : set) {
            if (map.containsKey(val))
                answer++;
        }

        return answer;
    }

    public void dfs(int depth, int n, int[] arr) {
        if (depth == n) {
            StringBuilder sb = new StringBuilder();
            for (int val : result) {
                sb.append(val);
            }
            int num = Integer.parseInt(sb.toString());
            set.add(num);
            return;
        }
        for (int i = 0; i < n; i++) {
            if (!visit[i]) {
                visit[i] = true;
                result[depth] = arr[i];
                func(result, depth);
                dfs(depth + 1, n, arr);
                visit[i] = false;
            }
        }
    }

    public void func(int[] result, int depth) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i <= depth; i++) {
            sb.append(result[i]);
        }
        int num = Integer.parseInt(sb.toString());
        set.add(num);
    }

    public void isPrime() {
        int n = 10000000;
        prime[0] = prime[1] = true;
        for (int i = 2; i * i <= n; i++) {
            if (!prime[i]) {
                for (int j = i * i; j <= n; j += i) {
                    prime[j] = true;
                }
            }
        }

        for (int i = 0; i <= n; i++) {
            if (!prime[i])
                map.put(i, i);
        }
    }
}
