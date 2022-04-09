package doit.c5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class DoIt26 {

    private static ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
    private static Queue<Integer> queue = new LinkedList<>();
    private static boolean[] visit;
    private static int n, m, start;
    private static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        start = Integer.parseInt(st.nextToken());

        // 초기화
        for (int i = 0; i <= n; i++)
            graph.add(new ArrayList<>());
        visit = new boolean[n + 1];

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            graph.get(x).add(y);
            graph.get(y).add(x);
        }

        for (int i = 1; i <= n; i++) {
            ArrayList<Integer> list = graph.get(i);
            Collections.sort(list);
            graph.set(i, list);
        }

        dfs(start);
        sb.append("\n");
        for (int i = 0; i < visit.length; i++)
            visit[i] = false;
        bfs(start);
        System.out.println(sb.toString());
    }

    private static void dfs(int start) {
        if (!visit[start]) {
            visit[start] = true;
            sb.append(start).append(" ");
            for (int i = 0; i < graph.get(start).size(); i++) {
                int num = graph.get(start).get(i);
                if (!visit[num])
                    dfs(num);
            }
        }
    }

    private static void bfs(int start) {
        queue.add(start);
        visit[start] = true;
        while (!queue.isEmpty()) {
            Integer num = queue.poll();
            sb.append(num).append(" ");
            for (int i = 0; i < graph.get(num).size(); i++) {
                int node = graph.get(num).get(i);
                if (!visit[node]) {
                    queue.add(node);
                    visit[node] = true;
                }
            }
        }
    }
}
