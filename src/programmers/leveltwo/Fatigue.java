package programmers.leveltwo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Fatigue {

    public static boolean[] visit;
    public static int[] per;
    public static List<int[]> list = new ArrayList<>();
    public static List<Integer> result = new ArrayList<>();
    public static int n;
    public static int m;

    public static int solution(int k, int[][] dungeons) {
        n = m = dungeons.length;
        per = new int[m];
        visit = new boolean[n];
        for(int[] val : dungeons) {
            list.add(val);
        }
        dfs(0, k);
        return Collections.max(result);
    }

    public static void dfs(int depth, int k) {
        int count = 0;
        if (depth == m) {
            for (int i = 0; i < m; i++) { // ex> per = {0,1,2}
                int[] arr = list.get(per[i]);
                if (k < arr[0]) break;
                else {
                    k = k - arr[1];
                    count++;
                }
            }
            result.add(count);
            return;
        }
        for (int i = 0; i < n; i++) {
            if (!visit[i]) {
                visit[i] = true;
                per[depth] = i;
                dfs(depth+1, k);
                visit[i] = false;
            }
        }
    }
}
