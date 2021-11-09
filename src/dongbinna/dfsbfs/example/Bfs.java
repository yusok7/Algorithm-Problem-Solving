package dongbinna.dfsbfs.example;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class Node {

    private int x;
    private int y;

    public Node(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
}

public class Bfs {

    public static int n, m;
    public static int[][] graph = new int[201][201];

    // 상, 하, 좌, 우
    /**
     * BFS에서는 꼭 필요한 것
     * 왜냐하면 BFS에서는 깊이가 아닌 해당 노드를 기점으로 주변 노드를 모두 탐색해야하므로!!
     * static int[] dx
     * static int[] dy
     */
    public static int[] dx = {-1, 1, 0, 0};
    public static int[] dy = {0, 0, -1, 1};

    public static int bfs(int x, int y) {
        /**
         * BFS에서는 Queue를 사용한다!!
         */
        Queue<Node> queue = new LinkedList<>();
        queue.add(new Node(x, y));
        /**
         * 큐가 빌때까지 무한 반복문을 돌려준다!!
         */
        while (!queue.isEmpty()) {
            Node node = queue.poll();
            x = node.getX();
            y = node.getY();
            for (int i = 0; i < 4; i++) {
                /**
                 * 방문하는 새로운 노드에 대해서는
                 * int nx
                 * int ny
                 * 를 선언해주자
                 */
                int nx = x + dx[i];
                int ny = y + dy[i];
                // 미로 찾기 공간을 벗어난 경우 무시
                if (nx < 0 || nx >= n || ny < 0 || ny >= m) continue;
                // 벽인 경우 무시
                if (graph[nx][ny] == 0) continue;
                /**
                 * 조건을 만족하는 경우에만 추가적으로 큐에 값을 넣어주자!!
                 */
                if (graph[nx][ny] == 1) {
                    graph[nx][ny] = graph[x][y] + 1;
                    queue.offer(new Node(nx, ny));
                }
            }
        }

        // 가장 오른쪽 아래까지의 최단 거리 반환
        return graph[n - 1][m - 1];
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // N, M을 공백을 기준으로 구분하여 입력 받기
        n = sc.nextInt();
        m = sc.nextInt();
        sc.nextLine(); // 버퍼 지우기

        // 2차원 리스트의 맵 정보 입력 받기
        for (int i = 0; i < n; i++) {
            String str = sc.nextLine();
            for (int j = 0; j < m; j++) {
                graph[i][j] = str.charAt(j) - '0';
            }
        }

        // BFS를 수행한 결과 출력
        System.out.println(bfs(0, 0));
    }

}
