package baekjoon.gold.gold5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Baekjoon16234 {

    static class Node {
        int x;
        int y;

        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    private static int[][] arr;
    private static boolean[][] bool;
    private static List<Node> list = new ArrayList<>();
    private static Queue<Node> queue = new LinkedList<>();

    // 북 동 남 서
    private static int[] dx = {0, 1, 0, -1};
    private static int[] dy = {-1, 0, 1, 0};

    private static int n, l, r;
    private static boolean check = false;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        l = Integer.parseInt(st.nextToken());
        r = Integer.parseInt(st.nextToken());

        arr = new int[n][n];
        bool = new boolean[n][n];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                int num = Integer.parseInt(st.nextToken());
                arr[i][j] = num;
            }
        }

        int answer = 0;
        while (true) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (!bool[i][j])
                        bfs(i, j);
                }
            }
            if (!check)
                break;
            answer++;
            check = false;
            reset();
        }
        System.out.println(answer);
    }

    private static void bfs(int i, int j) {
        bool[i][j] = true;
        queue.add(new Node(i, j));
        list.add(new Node(i, j));
        while (!queue.isEmpty()) {
            Node poll = queue.poll();
            int x = poll.x;
            int y = poll.y;
            for (int a = 0; a < 4; a ++) {
                int nx = x + dx[a];
                int ny = y + dy[a];
                if (nx < 0 || ny < 0 || nx >= n || ny >= n)
                    continue;
                // 방문했다면 들리지 않는다.
                if (bool[nx][ny] == true)
                    continue;
                int sub = Math.abs(arr[x][y] - arr[nx][ny]);
                if (sub >= l && sub <= r) {
                    bool[nx][ny] = true;
                    queue.add(new Node(nx, ny));
                    list.add(new Node(nx, ny));
                }
            }
        }
        if (list.size() == 1) {
            list.clear();
            return;
        }
        check = true;
        int size = list.size();
        int sum = 0;
        for (Node node : list) {
            sum += arr[node.x][node.y];
        }
        sum = sum / size;
        for (Node node : list) {
            arr[node.x][node.y] = sum;
        }
        list.clear();
    }

    private static void reset() {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                bool[i][j] = false;
            }
        }
    }
}
