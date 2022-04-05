package baekjoon.silver.silver1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Baekjoon16926 {

    private static int n, m, r, direction;

    private static int[][] arr;
    private static int[][] answer;

    // 남 동 북 서
    private static int[] dx = {1, 0, -1, 0};
    private static int[] dy = {0, 1, 0, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        r = Integer.parseInt(st.nextToken());
        arr = new int[n][m];
        answer = new int[n][m];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int min = Math.min(n, m) / 2;

        for (int t = 0; t < min; t++) {
            int startX = t;
            int startY = t;
            int x = startX;
            int y = startY;

            StringBuilder sb = new StringBuilder();
            sb.append(arr[x][y]).append(" ");
            while (true) {
                int nx = x + dx[direction];
                int ny = y + dy[direction];
                if (nx < 0 || ny < 0 || nx >= n || ny >= m) {
                    func();
                    continue;
                }
                if (answer[nx][ny] != 0) {
                    func();
                    continue;
                }
                if (nx == startX && ny == startY)
                    break;
                sb.append(arr[nx][ny]).append(" ");
                x = nx;
                y = ny;
            }

            String[] strArr = sb.toString().split(" ");
            Deque<String> queue = new LinkedList<>();
            for (String s : strArr)
                queue.add(s);
            for (int i = 0; i < r; i++) {
                String poll = queue.pollLast();
                queue.addFirst(poll);
            }

            x = startX;
            y = startY;

            answer[x][y] = Integer.parseInt(queue.poll());
            direction = 0;
            while (true) {
                int nx = x + dx[direction];
                int ny = y + dy[direction];
                if (nx < 0 || ny < 0 || nx >= n || ny >= m) {
                    func();
                    continue;
                }
                if (answer[nx][ny] != 0) {
                    func();
                    continue;
                }
                if (nx == startX && ny == startY)
                    break;
                answer[nx][ny] = Integer.parseInt(queue.poll());
                x = nx;
                y = ny;
                if (queue.isEmpty())
                    break;
            }
        }

        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < answer.length; i++) {
            for (int j = 0; j < answer[0].length; j++) {
                stringBuilder.append(answer[i][j]).append(" ");
            }
            stringBuilder.append("\n");
        }

        System.out.println(stringBuilder.toString());
    }

    private static void func() {
        direction++;
        if (direction == 4)
            direction = 0;
    }
}
