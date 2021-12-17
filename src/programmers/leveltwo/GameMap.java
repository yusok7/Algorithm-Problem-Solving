package programmers.leveltwo;

import java.util.LinkedList;
import java.util.Queue;

public class GameMap {

    static class Node {
        int x;
        int y;

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

    public static Queue<Node> queue = new LinkedList<>();

    // 동, 서, 남, 북
    public static int[] dx = {1, -1, 0, 0};
    public static int[] dy = {0, 0, 1, -1};

    public static int solution(int[][] maps) {
        int answer = 0;
        int n = maps.length;
        int m = maps[0].length;

        queue.add(new Node(0, 0));

        while (!queue.isEmpty()) {
            Node node = queue.poll();
            int x = node.getX();
            int y = node.getY();
            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];
                if (nx < 0 || ny < 0 || nx >= maps.length || ny >= maps[0].length) {
                    continue;
                }
                if (maps[nx][ny] != 1) {
                    continue;
                }
                queue.add(new Node(nx, ny));
                maps[nx][ny] = maps[x][y] + 1;
            }
        }
        if (maps[n-1][m-1] == 1) {
            answer = -1;
        } else {
            answer = maps[n-1][m-1];
        }
        return answer;
    }
}
