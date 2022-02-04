package baekjoon.silver.silver4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baekjoon13567 {

    // 북 동 남 서
    private static int[] dx = {0, 1, 0, -1};
    private static int[] dy = {1, 0, -1, 0};

    private static int m, n, direction, x, y;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        m = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());
        direction = 1;

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            String str = st.nextToken();
            int num = Integer.parseInt(st.nextToken());

            if (str.equals("TURN") && num == 0)
                turnLeft();
            else if (str.equals("TURN") && num == 1)
                turnRight();
            else {
                int nx = x + (num * dx[direction]);
                int ny = y + (num * dy[direction]);
                if (nx < 0 || ny < 0 || nx > m || ny > m){
                    System.out.println(-1);
                    System.exit(0);
                }
                x = nx;
                y = ny;
            }
        }
        System.out.println(x + " " + y);

    }

    private static void turnLeft() {
        direction -= 1;
        if (direction == -1)
            direction = 3;
    }

    private static void turnRight() {
        direction += 1;
        if (direction == 4)
            direction = 0;
    }
}
