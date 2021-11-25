package baekjoon.gold.gold5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Baekjoon10026 {

    static class Node {
        int x;
        int y;
        String str;

        public Node(int x, int y, String str) {
            this.x = x;
            this.y = y;
            this.str = str;
        }

        public int getX() {
            return x;
        }

        public int getY() {
            return y;
        }

        public String getStr() {
            return str;
        }
    }

    public static Queue<Node> queue = new LinkedList<>();
    public static String[][] arr;
    public static String[][] arr2;
    public static int n;
    public static boolean bool = false;

    // 동, 서, 남, 북
    public static int[] dx = {1, -1, 0, 0};
    public static int[] dy = {0, 0, 1, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        arr = new String[n][n];
        arr2 = new String[n][n];


        for (int i = 0; i < n; i++) {
            String[] strArr = br.readLine().split("");
            for (int j = 0; j < n; j++) {
                arr[i][j] = strArr[j];
                arr2[i][j] = strArr[j];
            }
        }

        // 정상인 먼저 진행
        int count1 = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (!arr[i][j].equals("-")) {
                    queue.add(new Node(i, j, arr[i][j]));
                    bfs(i, j);
                    count1++;
                }
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                arr[i][j] = arr2[i][j];
            }
        }

        bool = true;
        // 비 정상인 진행
        int count2 = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (!arr[i][j].equals("-")) {
                    queue.add(new Node(i, j, arr[i][j]));
                    bfs(i, j);
                    count2++;
                }
            }
        }

        System.out.println(count1 + " " + count2);
    }

    public static void bfs(int x, int y) {
        while (!queue.isEmpty()) {
            Node node = queue.poll();
            x = node.getX();
            y = node.getY();
            String str = node.getStr();
            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];
                if (nx < 0 || ny < 0 || nx >= n || ny >= n) continue;
                else {
                    if (arr[nx][ny].equals(str)) {
                        queue.add(new Node(nx, ny, arr[nx][ny]));
                        arr[nx][ny] = "-"; // 방문처리
                    }

                    if (bool && ((str.equals("R") && arr[nx][ny].equals("G")) || (str.equals("G") && arr[nx][ny].equals("R")))) {
                        queue.add(new Node(nx, ny, arr[nx][ny]));
                        arr[nx][ny] = "-"; // 방문처리
                    }
                }
            }
        }
    }
}
