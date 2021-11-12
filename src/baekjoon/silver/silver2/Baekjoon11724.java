package baekjoon.silver.silver2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

/**
 * Dongbinna 142 응용문제
 */

public class Baekjoon11724 {

    public static ArrayList<ArrayList<Integer>> graph = new ArrayList<ArrayList<Integer>>();
    public static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int n = Integer.parseInt(st.nextToken()); // 정점개수
        int m = Integer.parseInt(st.nextToken()); // 간선개수
        visited = new boolean[n+1];

        // 그래프 초기화
        for (int i = 0; i < n+1; i++) {
            graph.add(new ArrayList<Integer>());
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            graph.get(a).add(b);
            graph.get(b).add(a);

        }

        int count = 0;
        for (int i = 1; i < n+1; i++) {
            if (dfs(i)) count++;
        }
        System.out.println(count);
    }

    public static boolean dfs(int x) {
        if (!visited[x]) { // x번 정점을 방문하지 않았다면
            visited[x] = true;
            for (int i = 0; i < graph.get(x).size(); i++) {
                int y = graph.get(x).get(i);
                if (!visited[y]) dfs(y);
            }
            return true;
        }
        return false;
    }
}
