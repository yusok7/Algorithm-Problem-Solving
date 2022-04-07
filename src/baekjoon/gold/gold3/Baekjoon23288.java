package baekjoon.gold.gold3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Baekjoon23288 {

    private static int n, m, k, direction, answer;
    private static int[][] board;
    private static boolean[][] visit;
    private static int[] arr;
    private static int[] copy;

    // 동 남 서 북
    private static int[] dx = {0, 1, 0, -1};
    private static int[] dy = {1, 0, -1, 0};

    private static Queue<int[]> queue = new LinkedList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        board = new int[n][m];
        visit = new boolean[n][m];
        arr = new int[] {0, 1, 2, 3, 4, 5, 6};
        copy = new int[7];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                int num = Integer.parseInt(st.nextToken());
                board[i][j] = num;
            }
        }

        queue.add(new int[] {0, 0});
        for (int i = 0; i < k; i++) {
            int[] poll = queue.poll();
            int x = poll[0];
            int y = poll[1];

            // 1. 주사위가 이동방향으로 한 칸 굴러간다.
            int nx = x + dx[direction];
            int ny = y + dy[direction];
            if (nx < 0 || ny < 0 || nx >= n || ny >= m) {
                x = x - dx[direction];
                y = y - dy[direction];
                if (direction == 0) {
                    direction = 2;
                } else if (direction == 1) {
                    direction = 3;
                } else if (direction == 2) {
                    direction = 0;
                } else if (direction == 3) {
                    direction = 1;
                }
            } else {
                x = nx;
                y = ny;
            }
            queue.add(new int[] {x, y});

            turn(direction);
            copy();

            // 2. 주사위가 도착한 칸 (x, y)에 대한 점수를 획득한다.
            func(x, y);

            // 3. 다음 방향 결정
            int bottom = arr[6];
            if (bottom > board[x][y])
                turnRight();
            else if (bottom < board[x][y])
                turnLeft();
        }

        System.out.println(answer);
    }

    private static void turnRight() {
        direction++;
        if (direction == 4)
            direction = 0;
    }

    private static void turnLeft() {
        direction--;
        if (direction == -1)
            direction = 3;
    }

    private static void func(int x, int y) {
        int count = 0;
        int num = board[x][y];
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[] {x, y});
        visit[x][y] = true;
        while (!q.isEmpty()) {
            count++;
            int[] poll = q.poll();
            x = poll[0];
            y = poll[1];
            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];
                if (nx < 0 || ny < 0 || nx >= n || ny >= m)
                    continue;
                if (visit[nx][ny])
                    continue;
                if (board[nx][ny] == num) {
                    q.add(new int[] {nx, ny});
                    visit[nx][ny] = true;
                }
            }
        }
        answer += num * count;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                visit[i][j] = false;
            }
        }
    }

    private static void turn(int num) {
        if (num == 0) {
            copy[1] = arr[4];
            copy[2] = arr[2];
            copy[3] = arr[1];
            copy[4] = arr[6];
            copy[5] = arr[5];
            copy[6] = arr[3];
        } else if (num == 2) {
            copy[1] = arr[3];
            copy[2] = arr[2];
            copy[3] = arr[6];
            copy[4] = arr[1];
            copy[5] = arr[5];
            copy[6] = arr[4];
        } else if (num == 3) {
            copy[1] = arr[5];
            copy[2] = arr[1];
            copy[3] = arr[3];
            copy[4] = arr[4];
            copy[5] = arr[6];
            copy[6] = arr[2];
        } else if (num == 1) {
            copy[1] = arr[2];
            copy[2] = arr[6];
            copy[3] = arr[3];
            copy[4] = arr[4];
            copy[5] = arr[1];
            copy[6] = arr[5];
        }
    }

    private static void copy() {
        for (int i = 0; i < arr.length; i++)
            arr[i] = copy[i];
    }
}
