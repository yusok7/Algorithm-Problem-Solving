package baekjoon.silver.silver3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Baekjoon2606 {

    public static ArrayList<ArrayList<Integer>> graph = new ArrayList<ArrayList<Integer>>();
    public static boolean[] visit;

    public static boolean dfs(int x) {
        if (!visit[x]) {
            visit[x] = true;
            for (int i = 0; i < graph.get(x).size(); i++) { // x번 노드와 연결되어 있는 모든 노드에 대해서
                int y = graph.get(x).get(i);
                if (!visit[y]) dfs(y);
            }
            return true;
        }
        return false;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int node = Integer.parseInt(br.readLine());

        // 그래프 초기화
        for (int i = 0; i <= node; i++) {
            graph.add(new ArrayList<Integer>());
        }
        visit = new boolean[node+1]; // 1번노드부터 시작

        int n = Integer.parseInt(br.readLine());
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            graph.get(a).add(b);
        }

        int count = 0;
        dfs(1);
        for (int i = 1; i < visit.length; i++) {
            if (visit[i]) count++;
        }
        System.out.println(count-1);
    }
}
