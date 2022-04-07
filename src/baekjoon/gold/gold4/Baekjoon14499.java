package baekjoon.gold.gold4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baekjoon14499 {

    private static int n, m, x, y, k;

    private static int[][] board;
    private static int[] arr;
    private static int[] copy;

    // 동 서 북 남
    private static int[] dx = {0, 0, -1, 1};
    private static int[] dy = {1, -1, 0, 0};

    public static void main(String[] args) throws IOException {
        StringBuilder sb = new StringBuilder();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        x = Integer.parseInt(st.nextToken());
        y = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        board = new int[n][m];
        arr = new int[7];
        copy = new int[7];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < k; i++) {
            int num = Integer.parseInt(st.nextToken()) - 1;
            int nx = x + dx[num];
            int ny = y + dy[num];
            if (nx < 0 || ny < 0 || nx >= n || ny >= m)
                continue;
            turn(num);
            copy();
            x = nx;
            y = ny;
            if (board[x][y] == 0)
                board[x][y] = arr[6];
            else {
                arr[6] = board[x][y];
                board[x][y] = 0;
            }
            sb.append(arr[1]).append("\n");
        }
        System.out.println(sb.toString());
    }

    private static void turn(int num) {
        if (num == 0) {
            copy[1] = arr[4];
            copy[2] = arr[2];
            copy[3] = arr[1];
            copy[4] = arr[6];
            copy[5] = arr[5];
            copy[6] = arr[3];
        } else if (num == 1) {
            copy[1] = arr[3];
            copy[2] = arr[2];
            copy[3] = arr[6];
            copy[4] = arr[1];
            copy[5] = arr[5];
            copy[6] = arr[4];
        } else if (num == 2) {
            copy[1] = arr[5];
            copy[2] = arr[1];
            copy[3] = arr[3];
            copy[4] = arr[4];
            copy[5] = arr[6];
            copy[6] = arr[2];
        } else if (num == 3) {
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
