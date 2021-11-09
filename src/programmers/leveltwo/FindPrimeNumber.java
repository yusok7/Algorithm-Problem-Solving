package programmers.leveltwo;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class FindPrimeNumber {

    public boolean[] prime = new boolean[10000001];
    public List<Integer> list = new ArrayList<>();

    public boolean[] visit;
    public int[] arr;
    public List<int[]> perList = new ArrayList<>();

    public int solution(String numbers) {
        int answer = 0;
        findPrime();

        int length = numbers.length();
        visit = new boolean[length];
        arr = new int[length];
        dfs(length, length, 0);

        String[] strArr = numbers.split("");
        List<Integer> number = new ArrayList<>();
        for (int i = 0; i < strArr.length; i++) {
            number.add(Integer.parseInt(strArr[i]));
        }

        for (int[] val : perList) {
            String str = "";
            for (int var : val) {
                str += strArr[var];
            }
            number.add(Integer.parseInt(str));
        }

        Set<Integer> set = new HashSet<>();
        for (Integer val : number) {
            set.add(val);
        }

        for (Integer val : set) {
            if (list.contains(val)) {
                answer++;
            }
        }

        return answer;
    }

    public void dfs(int n, int m, int depth) {
        // 종료조건
        if (depth == m) {
            int[] output = new int[m];
            for (int i = 0; i < m; i++) {
                output[i] = arr[i];
            }
            perList.add(output);
            return;
        }
        for (int i = 0; i < n; i++) {
            if (!visit[i]) {
                visit[i] = true;
                arr[depth] = i;
                dfs(n, m, depth + 1);
                visit[i] = false;
            }
        }
    }

    public void findPrime() {
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
            if (!prime[i]) {
                list.add(i);
            }
        }
    }
}
