package baekjoon.silver.silver2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Baekjoon8911 {

    private static int colMin, colMax, rowMin, rowMax;
    private static int direction;

    // 북 동 남 서
    private static int[] dx = {-1, 0, 1, 0};
    private static int[] dy = {0, 1, 0, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        for (int i = 0; i < t; i++) {
            int row = 0;
            int col = 0;
            colMin = colMax = rowMin = rowMax = 0;
            direction = 0;
            String s = br.readLine();
            for (int j = 0; j < s.length(); j++) {
                String str = String.valueOf(s.charAt(j));
                if (str.equals("F")) {
                    row = row + dx[direction];
                    col = col + dy[direction];
                    func(row, col);
                } else if (str.equals("B")) {
                    row = row - dx[direction];
                    col = col - dy[direction];
                    func(row, col);
                } else if (str.equals("L")) {
                    turnLeft();
                } else if (str.equals("R")) {
                    turnRight();
                }
            }

            row = Math.abs(rowMax - rowMin);
            col = Math.abs(colMax - colMin);
            System.out.println(row * col);
        }
    }

    private static void turnLeft() {
        direction--;
        if (direction < 0)
            direction = 3;
    }

    private static void turnRight() {
        direction++;
        if (direction > 3)
            direction = 0;
    }

    private static void func(int row, int col) {
        colMin = Math.min(col, colMin);
        colMax = Math.max(col, colMax);
        rowMin = Math.min(row, rowMin);
        rowMax = Math.max(row, rowMax);
    }
}
