package baekjoon.silver.silver2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Baekjoon18352 {

    static class Node {
        private int x;
        private int distance;

        public Node(int x, int distance) {
            this.x = x;
            this.distance = distance;
        }

        public int getX() {
            return x;
        }

        public int getDistance() {
            return distance;
        }
    }

    public static ArrayList<ArrayList<Node>> graph = new ArrayList<>();
    public static Queue<Node> queue = new LinkedList<>();
    public static Map<Integer, Integer> map = new HashMap<>();
    public static List<Integer> list = new ArrayList<>();
    public static boolean[] visit;
    public static int n;
    public static int m;
    public static int k;
    public static int start;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        start = Integer.parseInt(st.nextToken());

        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }

        visit = new boolean[n+1];

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            graph.get(x).add(new Node(y, 0));
        }

        bfs(start);

        for (Integer key : map.keySet()) {
            if (map.get(key) == k) {
                list.add(key);
            }
        }

        if (list.size() == 0) {
            System.out.println(-1);
            System.exit(0);
        }

        Collections.sort(list);
        for (Integer val : list) {
            System.out.println(val);
        }
    }

    public static void bfs(int start) {
        queue.add(new Node(start, 0));
        visit[start] = true;
        map.put(start, 0);
        while (!queue.isEmpty()) {
            Node node = queue.poll();
            int x = node.getX();
            int distance = node.getDistance();
            for (int i = 0; i < graph.get(x).size(); i++) {
                Node node2 = graph.get(x).get(i);
                int x2 = node2.getX();
                int distance2 = distance + 1;
                if (!visit[x2]) {
                    visit[x2] = true;
                    queue.add(new Node(x2, distance2));
                    map.put(x2, distance2);
                }
            }
        }
    }
}
