package baekjoon.silver.silver4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Baekjoon1913 {

    private static int n;
    private static int answerX = 0;
    private static int answerY = 0;
    private static int[][] arr;

    // 남 동 북 서
    private static int[] dx = {1, 0, -1, 0};
    private static int[] dy = {0, 1, 0, -1};

    private static int direction = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());
        arr = new int[n][n];

        int num = n * n;

        int x = 0;
        int y = 0;

        arr[x][y] = num--;

        while (true) {
            int nx = x + dx[direction];
            int ny = y + dy[direction];
            if (nx < 0 || ny < 0 || nx >= n || ny >= n) {
                turnLeft();
                nx = x + dx[direction];
                ny = y + dy[direction];
                arr[nx][ny] = num--;
                func(m, nx, ny);
                x = nx;
                y = ny;
                continue;
            } else if (arr[nx][ny] != 0) {
                turnLeft();
                nx = x + dx[direction];
                ny = y + dy[direction];
                arr[nx][ny] = num--;
                func(m, nx, ny);
                x = nx;
                y = ny;
            } else {
                arr[nx][ny] = num--;
                func(m, nx, ny);
                x = nx;
                y = ny;
            }

            if (num == 0)
                break;
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length; j++) {
                sb.append(arr[i][j]).append(" ");
            }
            sb.append("\n");
        }
        sb.append(answerX + 1).append(" ").append(answerY + 1);
        System.out.println(sb.toString());
    }

    private static void func(int m, int nx, int ny) {
        if (arr[nx][ny] == m) {
            answerX = nx;
            answerY = ny;
        }
    }

    private static void turnLeft() {
        direction++;
        if (direction == 4)
            direction = 0;
    }
}
