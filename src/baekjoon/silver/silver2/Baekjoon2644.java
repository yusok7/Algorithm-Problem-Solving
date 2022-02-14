package baekjoon.silver.silver2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Baekjoon2644 {

    private static ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
    private static int n;

    private static Queue<int[]> queue = new LinkedList<>();
    private static boolean[] visit;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        // 초기화
        for (int i = 0; i <= n; i++)
            graph.add(new ArrayList<>());
        visit = new boolean[n + 1];

        StringTokenizer st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        queue.add(new int[]{a, 0});
        visit[a] = true;

        int t = Integer.parseInt(br.readLine());
        for (int i = 0; i < t; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            graph.get(x).add(y);
            graph.get(y).add(x);
        }

        while (!queue.isEmpty()) {
            int[] poll = queue.poll();
            int node = poll[0];
            int count = poll[1];
            if (node == b) {
                System.out.println(count);
                System.exit(0);
            }
            for (Integer val : graph.get(node)) {
                if (!visit[val]) {
                    queue.add(new int[] {val, count + 1});
                    visit[val] = true;
                }
            }
        }
        System.out.println(-1);
    }
}
