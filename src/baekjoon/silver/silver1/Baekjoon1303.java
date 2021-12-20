package baekjoon.silver.silver1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Baekjoon1303 {

    static class Node {
        int x;
        int y;

        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public int getX() {
            return x;
        }

        public int getY() {
            return y;
        }
    }

    public static int wSum = 0;
    public static int bSum = 0;
    public static int n;
    public static int m;

    public static int[] dx = {1, -1, 0, 0};
    public static int[] dy = {0, 0, 1, -1};
    public static String[][] arr;

    public static Queue<Node> queue = new LinkedList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        m = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());
        arr = new String[n][m];

        for (int i = 0; i < n; i++) {
            String[] strArr = br.readLine().split("");
            for (int j = 0; j < m; j++) {
                arr[i][j] = strArr[j];
            }
        }
        bfs();
        System.out.println(wSum + " " + bSum);
    }

    public static void bfs() {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (!arr[i][j].equals("0")) {
                    int x = i;
                    int y = j;
                    int count = 1;
                    String s = arr[x][y]; // "W" 혹은 "B"
                    queue.add(new Node(x, y));
                    while (!queue.isEmpty()) {
                        Node node = queue.poll();
                        x = node.getX();
                        y = node.getY();
                        arr[x][y] = "0";
                        for (int k = 0; k < 4; k++) {
                            int nx = x + dx[k];
                            int ny = y + dy[k];
                            if (nx < 0 || ny < 0 || nx >= n || ny >= m) {
                                continue;
                            }
                            if (arr[nx][ny].equals(s)) {
                                queue.add(new Node(nx, ny));
                                count++;
                                arr[nx][ny] = "0";
                            }
                        }
                    }
                    if (s.equals("W")) {
                        wSum += Math.pow(count, 2);
                    } else {
                        bSum += Math.pow(count , 2);
                    }
                } else {
                    continue;
                }
            }
        }
    }
}
