package baekjoon.silver.silver1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Baekjoon18405 {

    static class Node implements Comparable<Node> {
        int x;
        int y;
        int num;

        public Node(int x, int y, int num) {
            this.x = x;
            this.y = y;
            this.num = num;
        }

        @Override
        public int compareTo(Node o) {
            return Integer.compare(this.num, o.num);
        }
    }

    private static Node[][] arr;

    private static List<Node> list = new ArrayList<>();

    // 북 동 남 서
    private static int[] dx = {0, 1, 0, -1};
    private static int[] dy = {-1, 0, 1, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        arr = new Node[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                arr[i][j] = new Node(0, 0, 0);
            }
        }

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                int num = Integer.parseInt(st.nextToken());
                Node node = new Node(i, j, num);
                arr[i][j] = node;
            }
        }

        st = new StringTokenizer(br.readLine());
        int s = Integer.parseInt(st.nextToken());
        int resultX = Integer.parseInt(st.nextToken()) - 1;
        int resultY = Integer.parseInt(st.nextToken()) - 1;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (arr[i][j].num != 0) {
                    list.add(arr[i][j]);
                }
            }
        }
        Collections.sort(list);

        while (s-- > 0) {
            int size = list.size();
            for (int t = 0; t < size; t++) {
                Node poll = list.get(0);
                int x = poll.x;
                int y = poll.y;
                int num = poll.num;
                list.remove(0);

                for (int i = 0; i < 4; i++) {
                    int nx = x + dx[i];
                    int ny = y + dy[i];
                    if (nx < 0 || ny < 0 || nx >= n || ny >= n)
                        continue;
                    if (arr[nx][ny].num == 0) {
                        Node newNode = new Node(nx, ny, num);
                        arr[nx][ny] = newNode;
                        list.add(newNode);
                    }
                }
            }
        }

        System.out.println(arr[resultX][resultY].num);
    }
}
