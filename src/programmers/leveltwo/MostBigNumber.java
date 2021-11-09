package programmers.leveltwo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * https://programmers.co.kr/learn/courses/30/lessons/42746?language=java
 */

public class MostBigNumber {

    public static int m = 0;
    public static int[] arr;
    public static boolean[] visit;
    public static List<int[]> list = new ArrayList<>();

    public String solution(int[] numbers) {

        List<Integer> result = new ArrayList<>();

        m = numbers.length;
        arr = new int[m];
        visit = new boolean[m];

        dfs(m,m,0);

        for (int[] array : list) {
            String str = "";
            for (int i : array) {
                str += numbers[i];
            }
            if (str.startsWith("0")) {
                continue;
            } else {
                result.add(Integer.parseInt(str));
            }
        }

        Collections.sort(result);
        String answer = String.valueOf(Collections.max(result));
        return answer;
    }

    public void dfs(int n, int m, int depth) {
        // 종료조건
        if (depth == m) {
            int[] output = new int[m];
            for (int i = 0; i < m; i++) {
                output[i] = arr[i];
            }
            list.add(output);
            return;
        }
        for (int i = 0; i < n; i++) {
            if(!visit[i]) {
                visit[i] = true;
                arr[depth] = i;
                dfs(n, m, depth+1);
                visit[i] = false;
            }
        }
    }
}
