package baekjoon.bronze.bronze2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baekjoon1952 {

    private static int[][] arr;
    private static int n, m;

    // 동 남 서 북
    private static int[] dx = {0, 1, 0, -1};
    private static int[] dy = {1, 0, -1, 0};

    private static int direction = 0;
    private static int answer = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        arr = new int[n][m];
        arr[0][0] = 1;

        int x = 0;
        int y = 0;
        while (true) {
            boolean bool = false;
            int nx = x + dx[direction];
            int ny = y + dy[direction];

            if (nx < 0 || ny < 0 || nx >= n || ny >= m) {
                bool = true;
                turnRight();
                answer++;
            } else if (arr[nx][ny] == 1) {
                bool = true;
                turnRight();
                answer++;
            }

            if (bool) {
                nx = x + dx[direction];
                ny = y + dy[direction];
                if (arr[nx][ny] == 1) {
                    answer--;
                    break;
                }
                arr[nx][ny] = 1;
                x = nx;
                y = ny;
            } else {
                arr[nx][ny] = 1;
                x = nx;
                y = ny;
            }
        }
        System.out.println(answer);
    }

    private static void turnRight() {
        direction++;
        if (direction == 4)
            direction = 0;
    }
}
