package dongbinna.implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Dongbinna118 {

    private static int[][] arr;
    private static int direction;

    // 북, 동, 남, 서
    private static int[] dx = {-1, 0, 1, 0};
    private static int[] dy = {0, 1, 0, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        arr = new int[n][m];

        st = new StringTokenizer(br.readLine());
        int x = Integer.parseInt(st.nextToken());
        int y = Integer.parseInt(st.nextToken());
        direction = Integer.parseInt(st.nextToken());

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        arr[x][y] = 1;

        int turnTime = 0;
        int result = 1;
        while (true) {
            turnLeft();
            turnTime++;

            if (turnTime != 4) {
                int nx = x + dx[direction];
                int ny = y + dy[direction];
                if (nx < 0 || nx >= n || ny < 0 || ny >= m)
                    continue;
                if (arr[nx][ny] == 0) {
                    x = nx;
                    y = ny;
                    arr[x][y] = 1;
                    turnTime = 0;
                    result++;
                    continue;
                }
            } else {
                int nx = x - dx[direction];
                int ny = y - dy[direction];
                if (nx < 0 || nx >= n || ny < 0 || ny >= m)
                    break;
                if (arr[nx][ny] == 1)
                    break;
                x = nx;
                y = ny;
                turnTime = 0;
            }
        }
        System.out.println(result);
    }

    private static void turnLeft() {
        direction -= 1;
        if (direction == -1)
            direction = 3;
    }
}
