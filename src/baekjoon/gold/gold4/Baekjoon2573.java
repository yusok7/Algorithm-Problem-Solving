package baekjoon.gold.gold4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Baekjoon2573 {

    private static int n, m, result, island;
    private static int[][] arr;
    private static int[][] sub;
    private static boolean[][] visit;

    // 북 동 남 서
    private static int[] dx = {-1, 0, 1, 0};
    private static int[] dy = {0, 1, 0, -1};

    private static Queue<int[]> queue = new LinkedList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        result = 0;
        island = 0;

        arr = new int[n][m];
        sub = new int[n][m];
        visit = new boolean[n][m];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        while (true) {
            if (func3()) {
                System.out.println(0);
                break;
            }
            func();
            func2();
            bfs();
            initialize();
            result++;
            if (island >= 2) {
                System.out.println(result);
                break;
            }
            island = 0;
        }
    }

    // 주변에 바다가 몇개인지 확인하는 메서드
    private static void func() {
        copy();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                int count = 0;
                for (int k = 0; k < 4; k++) {
                    int nx = i + dx[k];
                    int ny = j + dy[k];
                    if (nx < 0 || ny < 0 || nx >= n || ny >= m)
                        continue;
                    if (arr[nx][ny] == 0)
                        count++;
                }
                sub[i][j] = count;
            }
        }
    }

    // 주변에 바다의 개수만큼 빼주는 함수
    private static void func2() {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                int num = arr[i][j] - sub[i][j];
                if (num < 0)
                    num = 0;
                arr[i][j] = num;
            }
        }
    }

    // 모두 녹았는지 확인하는 함수
    private static boolean func3() {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (arr[i][j] != 0)
                    return false;
            }
        }
        return true;
    }

    private static void bfs() {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (arr[i][j] != 0 && visit[i][j] == false) {
                    island++;
                    queue.add(new int[] {i, j});
                    visit[i][j] = true;
                    while (!queue.isEmpty()) {
                        int[] poll = queue.poll();
                        int x = poll[0];
                        int y = poll[1];
                        for (int k = 0; k < 4; k++) {
                            int nx = x + dx[k];
                            int ny = y + dy[k];
                            if (nx < 0 || ny < 0 || nx >= n || ny >= m)
                                continue;
                            if (visit[nx][ny] == true || arr[nx][ny] == 0)
                                continue;
                            queue.add(new int[] {nx, ny});
                            visit[nx][ny] = true;
                        }
                    }
                }
            }
        }
    }

    private static void copy() {
        for (int i = 0; i < n; i++)
            for (int j = 0; j < m; j++)
                sub[i][j] = arr[i][j];
    }

    private static void initialize() {
        for (int i = 0; i < n; i++)
            for (int j = 0; j < m; j++)
                visit[i][j] = false;
    }
}
