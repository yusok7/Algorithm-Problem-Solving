package baekjoon.silver.silver1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Baekjoon16918 {

    static class Node {
        int r;
        int c;
        int time;

        public Node(int r, int c, int time) {
            this.r = r;
            this.c = c;
            this.time = time;
        }
    }

    private static Queue<Node> queue = new LinkedList<>();

    private static String[][] arr;
    private static Node[][] nodeArr;
    private static boolean[][] bool;
    private static int r, c, n;

    // 동 서 남 북
    private static int[] dx = {0, 0, 1, -1};
    private static int[] dy = {1, -1, 0, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());
        arr = new String[r][c];
        nodeArr = new Node[r][c];
        bool = new boolean[r][c];

        for (int i = 0; i < r; i++) {
            String str = br.readLine();
            for (int j = 0; j < c; j++) {
                arr[i][j] = String.valueOf(str.charAt(j));
            }
        }

        add(0);

        for (int i = 2; i <= n; i++) {
            // 폭탄 추가
            if (i % 2 == 0) {
                for (int j = 0; j < r; j++) {
                    for (int k = 0; k < c; k++) {
                        if (arr[j][k].equals(".")) {
                            arr[j][k] = "O";
                            Node node = new Node(j, k, i);
                            queue.add(node);
                            nodeArr[j][k] = node;
                            bool[j][k] = true;
                        }
                    }
                }
            } else {
                int size = queue.size();
                for (int j = 0; j < size; j++) {
                    Node peek = queue.peek();
                    if (peek.time == i - 3) {
                        Node poll = queue.poll();
                        int row = poll.r;
                        int col = poll.c;
                        if (bool[row][col] == false)
                            continue;
                        arr[row][col] = ".";
                        bool[row][col] = false;
                        for (int k = 0; k < 4; k++) {
                            int nx = row + dx[k];
                            int ny = col + dy[k];
                            if (nx < 0 || ny < 0 || nx >= r || ny >= c)
                                continue;
                            Node node = nodeArr[nx][ny];
                            if (node.time == i - 3)
                                continue;
                            arr[nx][ny] = ".";
                            bool[nx][ny] = false;
                        }
                    } else {
                        break;
                    }
                }
            }
        }
        print();
    }

    private static void print() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                sb.append(arr[i][j]);
            }
            sb.append("\n");
        }
        System.out.println(sb.toString());
    }

    private static void add(int time) {
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if (arr[i][j].equals("O")) {
                    Node node = new Node(i, j, time);
                    queue.add(node);
                    nodeArr[i][j] = node;
                    bool[i][j] = true;
                }
            }
        }
    }
}
