package baekjoon.gold.gold5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Baekjoon21610 {

    private static int n, m;
    private static int[][] arr;
    private static int[][] copy;
    private static boolean[][] cloud;

    // 총 이동 거리 담은 리스트
    private static List<int[]> list = new ArrayList<>();
    // 구름의 좌표
    private static Queue<int[]> queue = new LinkedList<>();

    // 왼쪽, 왼쪽 대각선 위, 위쪽, 오른쪽 대각선 위, 오른쪽, 오른쪽 대각선 아래, 아래, 왼쪽 대각선 아래
    private static int[] dx = {0, -1, -1, -1, 0, 1, 1, 1};
    private static int[] dy = {-1, -1, 0, 1, 1, 1, 0, -1};

    //왼쪽 대각선 위, 오른쪽 대각선 위, 오른쪽 대각선 아래, 왼쪽 대각선 아래
    private static int[] dx2 = {-1, -1, 1, 1};
    private static int[] dy2 = {-1, 1, 1, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        arr = new int[n][n];
        copy = new int[n][n];
        cloud = new boolean[n][n];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int d = Integer.parseInt(st.nextToken());
            int s = Integer.parseInt(st.nextToken());
            list.add(new int[] {d, s});
        }

        cloud[n - 2][0] = cloud[n - 2][1] = cloud[n - 1][0] = cloud[n - 1][1] = true;
        for (int i = 0; i < 2; i++) {
            queue.add(new int[] {n - 2, i});
            queue.add(new int[] {n - 1, i});
        }

        for (int[] val : list) {
            int d = val[0]; // 이동방향
            int s = val[1]; // 이동할 거리
            s = s % n;
            int plusX = dx[d - 1] * s;
            int plusY = dy[d - 1] * s;
            func();

            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int[] poll = queue.poll();
                int nx = poll[0] + plusX;
                int ny = poll[1] + plusY;
                if (nx < 0)
                    nx = nx + n;
                if (nx >= n)
                    nx = nx - n;
                if (ny < 0)
                    ny = ny + n;
                if (ny >= n)
                    ny = ny - n;
                cloud[nx][ny] = true;
            }

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (!cloud[i][j])
                        copy[i][j] = arr[i][j];
                    else
                        copy[i][j] = 0;
                }
            }

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (cloud[i][j] == true) {
                        arr[i][j] += 1;
                        for (int k = 0; k < 4; k++) {
                            int nx = i + dx2[k];
                            int ny = j + dy2[k];
                            if (nx < 0 || ny < 0 || nx >= n || ny >= n)
                                continue;
                            if (arr[nx][ny] > 0)
                                copy[i][j]++;
                        }
                        copy[i][j] += arr[i][j];
                    }
                }
            }

            for (int i = 0; i < n; i++)
                for (int j = 0; j < n; j++)
                    arr[i][j] = copy[i][j];

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (arr[i][j] >= 2 && cloud[i][j] == false) {
                        queue.add(new int[] {i, j});
                        arr[i][j] -= 2;
                    }
                }
            }
        }

        int answer = 0;
        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++)
                answer += arr[i][j];
        System.out.println(answer);
    }

    // 구름의 위치 초기화
    private static void func() {
        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++)
                cloud[i][j] = false;
    }
}
