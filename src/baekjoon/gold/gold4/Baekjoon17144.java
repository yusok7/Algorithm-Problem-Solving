package baekjoon.gold.gold4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baekjoon17144 {

    private static int n, m;
    private static int direction = 0;
    private static int[][] arr;
    private static int[][] copy;

    // 동 북 서 남
    private static int[] dx = {0, -1, 0, 1};
    private static int[] dy = {1, 0, -1, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        int t = Integer.parseInt(st.nextToken());

        arr = new int[n][m];
        copy = new int[n][m];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                int num = Integer.parseInt(st.nextToken());
                arr[i][j] = num;
            }
        }

        for (int a = 0; a < t; a++) {
            func();
            copyArr();
            String str = "left";

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    if (arr[i][j] == -1) {
                        String s = func2(i, str);
                        func3(i, str, s);
                        str = "right";
                    }
                    copy[i][j] = 0;
                }
            }
        }

        int answer = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (arr[i][j] != -1)
                    answer += arr[i][j];
            }
        }
        System.out.println(answer);
    }

    // 확산 메소드
    private static void func() {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (arr[i][j] == -1) {
                    copy[i][j] = -1;
                    continue;
                }
                if (arr[i][j] != 0) {
                    int num = arr[i][j] / 5;
                    int count = 0;
                    for (int k = 0; k < 4; k++) {
                        int nx = i + dx[k];
                        int ny = j + dy[k];
                        if (nx < 0 || ny < 0 || nx >= n || ny >= m)
                            continue;
                        if (arr[nx][ny] == -1)
                            continue;
                        copy[nx][ny] += num;
                        count++;
                    }
                    num = num * count;
                    copy[i][j] += arr[i][j] - num;
                }
            }
        }
    }

    private static String func2(int row, String turn) {
        direction = 0;
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i < m; i++)
            sb.append(arr[row][i]).append(" ");
        check(turn);

        while (true) {
            row += dx[direction];
            if (row < 0) {
                row = 0;
                break;
            } else if (row >= n) {
                row = n - 1;
                break;
            } else {
                sb.append(arr[row][m - 1]).append(" ");
            }
        }
        check(turn);

        int col = m - 1;
        while (true) {
            col += dy[direction];
            if (col < 0) {
                col = 0;
                break;
            } else {
                sb.append(arr[row][col]).append(" ");
            }
        }
        check(turn);

        while (true) {
            row += dx[direction];
            if (arr[row][col] == -1)
                break;
            else
                sb.append(arr[row][col]).append(" ");
        }
        return sb.toString();
    }

    private static void func3(int row, String turn, String str) {
        direction = 0;
        String[] strArr = str.split(" ");
        int index = 0;

        arr[row][1] = 0;
        for (int i = 2; i < m; i++)
            arr[row][i] = Integer.parseInt(strArr[index++]);
        check(turn);

        while (true) {
            row += dx[direction];
            if (row < 0) {
                row = 0;
                break;
            } else if (row >= n) {
                row = n - 1;
                break;
            } else
                arr[row][m - 1] = Integer.parseInt(strArr[index++]);
        }
        check(turn);

        int col = m - 1;
        while (true) {
            col += dy[direction];
            if (col < 0) {
                col = 0;
                break;
            } else {
                arr[row][col] = Integer.parseInt(strArr[index++]);
            }
        }
        check(turn);

        while (true) {
            row += dx[direction];
            if (arr[row][col] == -1)
                break;
            else
                arr[row][col] = Integer.parseInt(strArr[index++]);
        }
    }

    private static void turnLeft() {
        direction = direction + 1;
    }

    private static void turnRight() {
        direction = direction - 1;
        if (direction < 0)
            direction = 3;
    }

    private static void copyArr() {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                arr[i][j] = copy[i][j];
            }
        }
    }

    private static void check(String str) {
        if (str.equals("left")) {
            turnLeft();
            return;
        }
        turnRight();
    }
}
