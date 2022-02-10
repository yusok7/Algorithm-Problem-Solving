package baekjoon.gold.gold5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Baekjoon2174 {

    static class Robot {
        int num;
        int x;
        int y;
        int direction;

        public Robot(int num, int x, int y, int direction) {
            this.num = num;
            this.x = x;
            this.y = y;
            this.direction = direction;
        }
    }

    // 북, 서, 남, 동
    private static int[] dx = {0, -1, 0, 1};
    private static int[] dy = {1, 0, -1, 0};
    private static List<String> list = Arrays.asList("N", "W", "S", "E");

    private static Robot[][] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        arr = new Robot[b][a];

        // 초기화
        for (int i = 0; i < b; i++) {
            for (int j = 0; j < a; j++) {
                arr[i][j] = new Robot(0, 0, 0, 0);
            }
        }

        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        for (int i = 0; i < n; i++) {
            int num = i + 1;
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken()) - 1;
            int y = Integer.parseInt(st.nextToken()) - 1;
            int direction = list.indexOf(st.nextToken());
            Robot robot = new Robot(num, x, y, direction);
            arr[y][x] = robot;
        }

        for (int i = 0; i < m; i++) {
            int x = 0;
            int y = 0;
            st = new StringTokenizer(br.readLine());
            int num = Integer.parseInt(st.nextToken());
            String command = st.nextToken();
            int count = Integer.parseInt(st.nextToken());
            int direction = 0;
            for (int j = 0; j < b; j++) {
                for (int k = 0; k < a; k++) {
                    if (arr[j][k].num == num) {
                        x = k;
                        y = j;
                        direction = arr[y][x].direction;
                        break;
                    }
                }
            }
            if (command.equals("L")) {
                direction = turnLeft(direction, count);
                Robot robot = new Robot(num, x, y, direction);
                arr[y][x] = robot;
            } else if (command.equals("R")) {
                direction = turnRight(direction, count);
                Robot robot = new Robot(num, x, y, direction);
                arr[y][x] = robot;
            } else {
                arr[y][x] = new Robot(0, 0, 0, 0);
                for (int j = 0; j < count; j++) {
                    int nx = x + dx[direction];
                    int ny = y + dy[direction];
                    if (nx < 0 || ny < 0 || nx >= a || ny >= b) {
                        System.out.println("Robot " + num +" crashes into the wall");
                        System.exit(0);
                    }
                    if (arr[ny][nx].num != 0) {
                        System.out.println("Robot " + num + " crashes into robot " + arr[ny][nx].num);
                        System.exit(0);
                    }
                    x = nx;
                    y = ny;
                    if (j == count - 1) {
                        arr[y][x] = new Robot(num, x, y, direction);
                    }
                }
            }
        }
        System.out.println("OK");
    }

    private static int turnLeft(int direction, int count) {
        direction = (direction + count) % 4;
        return direction;
    }

    private static int turnRight(int direction, int count) {
        for (int i = 0; i < count; i++) {
            direction = direction - 1;
            if (direction < 0)
                direction = 3;
        }
        return direction;
    }
}
