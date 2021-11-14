package programmers.levelthree;

import java.util.ArrayList;

public class Network {

    public static ArrayList<ArrayList<Integer>> graph = new ArrayList<ArrayList<Integer>>();
    public static boolean[] visit;

    public static boolean dfs(int x) {
        if (!visit[x]) {
            visit[x] = true;
            for (int i = 0; i < graph.get(x).size(); i++) {
                int y = graph.get(x).get(i);
                dfs(y);
            }
            return true;
        }
        return false;
    }

    public static int solution(int n, int[][] computers) {

        for (int i = 0; i <= computers.length; i++) {
            graph.add(new ArrayList<>());
        }
        visit = new boolean[n + 1];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i == j) continue;
                else {
                    if (computers[i][j] == 1) {
                        graph.get(i+1).add(j+1);
                    }
                }
            }
        }

        int answer = 0;

        for (int i = 1; i <= n; i++) {
            if (dfs(i)) answer++;
        }
        return answer;
    }

    public static void main(String[] args) {
        int n = 3;
        int[][] arr = 	{{1, 1, 0}, {1, 1, 0}, {0, 0, 1}};
        int solution = solution(n, arr);
        System.out.println("solution = " + solution);
    }
}
