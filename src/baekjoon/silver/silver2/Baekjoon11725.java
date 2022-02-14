package baekjoon.silver.silver2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Baekjoon11725 {

    private static ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
    private static List<int[]> list = new ArrayList<>();
    private static Queue<int[]> queue = new LinkedList<>();

    private static boolean[] visit;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        visit = new boolean[n + 1];

        // 초기화
        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < n - 1; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            graph.get(x).add(y);
            graph.get(y).add(x);
        }

        queue.add(new int[] {1, 1});
        visit[1] = true;
        while (!queue.isEmpty()) {
            int[] poll = queue.poll();
            int node = poll[0];
            for (int i = 0; i < graph.get(node).size(); i++) {
                int newNode = graph.get(node).get(i);
                if (!visit[newNode]) {
                    int[] arr = new int[]{newNode, node};
                    queue.add(arr);
                    list.add(arr);
                    visit[newNode] = true;
                }
            }
        }

        Collections.sort(list, (int[] arr1, int[] arr2) -> {
            return Integer.compare(arr1[0], arr2[0]);
        });
        for (int[] arr : list) {
            System.out.println(arr[1]);
        }
    }
}
