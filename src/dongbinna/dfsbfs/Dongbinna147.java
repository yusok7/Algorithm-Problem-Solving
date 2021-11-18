package dongbinna.dfsbfs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Dongbinna147 {

    public static boolean[] visited = new boolean[9]; // 1번 노드 ~ 8번 노드
    public static ArrayList<ArrayList<Integer>> graph = new ArrayList<ArrayList<Integer>>();

    public static void bfs(int start) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(start); // 1단계 : 탐색 시작 노드를 큐에 삽입하고
        visited[start] = true; // 1단계 : 방문 처리를 한다.

        while (!queue.isEmpty()) {
            int x = queue.poll(); // 2단계 : 큐에서 노드를 꺼내
            System.out.print(x + " ");
            for (int i = 0; i < graph.get(x).size(); i++) {
                int y = graph.get(x).get(i);
                if (!visited[y]) {
                    queue.add(y); // 2단계 : 해당 노드의 인접 노드 중에서 방문하지 않은 노드를 모두 큐에 삽입하고
                    visited[y] = true; // 2단계 : 방문처리를 한다.
                }
            }
        }
    }

    public static void main(String[] args) {
        // 그래프 초기화 해주기
        for (int i = 0; i < 9; i++) {
            graph.add(new ArrayList<Integer>());
        }

        // 노드 1에 연결된 노드 정보 저장
        graph.get(1).add(2);
        graph.get(1).add(3);
        graph.get(1).add(8);

        // 노드 2에 연결된 노드 정보 저장
        graph.get(2).add(1);
        graph.get(2).add(7);

        // 노드 3에 연결된 노드 정보 저장
        graph.get(3).add(1);
        graph.get(3).add(4);
        graph.get(3).add(5);

        // 노드 4에 연결된 노드 정보 저장
        graph.get(4).add(3);
        graph.get(4).add(5);

        // 노드 5에 연결된 노드 정보 저장
        graph.get(5).add(3);
        graph.get(5).add(4);

        // 노드 6에 연결된 노드 정보 저장
        graph.get(6).add(7);

        // 노드 7에 연결된 노드 정보 저장
        graph.get(7).add(2);
        graph.get(7).add(6);
        graph.get(7).add(8);

        // 노드 8에 연결된 노드 정보 저장
        graph.get(8).add(1);
        graph.get(8).add(7);

        bfs(1);

    }
}
