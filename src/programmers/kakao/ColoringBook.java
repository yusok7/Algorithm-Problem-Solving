package programmers.kakao;

import java.util.LinkedList;
import java.util.Queue;

public class ColoringBook {

    static class Node {
        int x;
        int y;

        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    private static Queue<Node> queue = new LinkedList<>();

    // 북 동 남 서
    private static int[] dx = {-1, 0, 1, 0};
    private static int[] dy = {0, 1, 0, -1};

    private static int numberOfArea = 0;
    private static int maxSizeOfOneArea = 0;

    private static int[][] board;

    public static void main(String[] args) {
        int[][] picture = {{1, 1, 1, 0}, {1, 2, 2, 0}, {1, 0, 0, 1}, {0, 0, 0, 1}, {0, 0, 0, 3}, {0, 0, 0, 3}};
        int[] solution = solution(6, 4, picture);
        System.out.println(solution[0]);
        System.out.println(solution[1]);

    }

    public static int[] solution(int m, int n, int[][] picture) {
        board = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                board[i][j] = picture[i][j];
            }
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if(board[i][j] != 0) {
                    numberOfArea++;
                    bfs(i, j);
                }
            }
        }

        int[] answer = new int[] {numberOfArea, maxSizeOfOneArea};
        return answer;
    }

    private static void bfs(int i, int j) {
        int count = 0;
        int num = board[i][j];
        Node node = new Node(i, j);
        queue.add(node);
        board[i][j] = 0;
        while(!queue.isEmpty()) {
            count++;
            node = queue.poll();
            int x = node.x;
            int y = node.y;
            for (int a = 0; a < 4; a++) {
                int nx = x + dx[a];
                int ny = y + dy[a];
                if (nx < 0 || ny < 0 || nx >= board.length || ny >= board[0].length)
                    continue;
                if (board[nx][ny] != num)
                    continue;
                queue.add(new Node(nx, ny));
                board[nx][ny] = 0;
            }
        }
        maxSizeOfOneArea = Math.max(maxSizeOfOneArea, count);
    }
}
