package doit.c5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class DoIt23 {

    private static ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
    private static boolean[] visit;

    private static int n, m, answer;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        // 초기화
        for (int i = 0; i <= n; i++)
            graph.add(new ArrayList<>());
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            graph.get(x).add(y);
            graph.get(y).add(x);
        }
        visit = new boolean[n + 1];

        for (int i = 1; i <= n; i++) {
            if (dfs(i))
                answer++;
        }
        System.out.println(answer);
    }

    private static boolean dfs(int x) {
        if (!visit[x]) {
            visit[x] = true;
            for (int i = 0; i < graph.get(x).size(); i++) {
                int num = graph.get(x).get(i);
                if (!visit[num])
                    dfs(num);
            }
            return true;
        }
        return false;
    }
}
