package programmers.levelthree;

import java.util.*;

/**
 * 1. 첫번째 노드를 큐에 넣고
 * 2. 큐에서 노드를 하나씩 꺼내 근처에 방문하지 않은 노드가 있다면 모두 큐에 넣어준다.
 * 3. 큐가 완전히 비어질 때까지 반복한다.
 */

public class FarthestNode {

    static class Node {
        int x;
        int distance;

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

    public static ArrayList<ArrayList<Node>> graph = new ArrayList<ArrayList<Node>>();
    public static boolean[] visit;
    public static Queue<Node> queue = new LinkedList<>();
    public static List<Integer> list = new ArrayList<>();

    public static int solution(int n, int[][] edge) {
        int answer = 0;
        // 방문배열 초기화
        visit = new boolean[n + 1];
        // 그래프 초기화
        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }
        // 그래프에 노드 집어넣기
        for (int i = 0; i < edge.length; i++) {
            int[] arr = edge[i];
            int x = arr[0];
            int y = arr[1];
            graph.get(x).add(new Node(y, 0));
            graph.get(y).add(new Node(x, 0));
        }

        bfs();

        list.add(1);
        int max = Collections.max(list);
        for (Integer val : list) {
            if (val == max) {
                answer++;
            }
        }
        return answer;
    }

    public static void bfs() {
        queue.add(new Node(1, 1));
        visit[1] = true;
        while (!queue.isEmpty()) {
            Node node = queue.poll();
            int x = node.getX();
            for (int i = 0; i < graph.get(x).size(); i++) {
                int x2 = graph.get(x).get(i).getX();
                if (!visit[x2]) { // 방문하지 않았다면
                    queue.add(new Node(x2, node.getDistance() + 1));
                    list.add(node.getDistance() + 1);
                    visit[x2] = true;
                }
            }
        }
    }
}
