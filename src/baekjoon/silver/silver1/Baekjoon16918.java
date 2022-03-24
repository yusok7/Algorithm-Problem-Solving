package baekjoon.silver.silver1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baekjoon16918 {

    // 북 동 남 서
    private static int[] dx = {-1, 0, 1, 0};
    private static int[] dy = {0, 1, 0, -1};

    private static String[][] answer;
    private static int[][] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        answer = new String[n][m];
        arr = new int[n][m];

        for (int i = 0; i < n; i++) {
            String s = br.readLine();
            for (int j = 0; j < m; j++) {
                String str = String.valueOf(s.charAt(j));
                if (str.equals("O"))
                    arr[i][j] = 0;
                else
                    arr[i][j] = -1;
            }
        }

        int time = 1;
        while (true) {
            if (time != 1) {
                // 폭탄 설치 시간
                if (time % 2 == 0) {
                    for (int i = 0; i < arr.length; i++)
                        for (int j = 0; j < arr[0].length; j++)
                            if (arr[i][j] == -1)
                                arr[i][j] = time;
                } else {
                    for (int i = 0; i < arr.length; i++) {
                        for (int j = 0; j < arr[0].length; j++) {
                            if (arr[i][j] == time - 3) {
                                arr[i][j] = -1;
                                for (int a = 0; a < 4; a++) {
                                    int nx = i + dx[a];
                                    int ny = j + dy[a];
                                    if (nx < 0 || ny < 0 || nx >= n || ny >= m)
                                        continue;
                                    if (arr[nx][ny] == time - 3)
                                        continue;
                                    arr[nx][ny] = -1;
                                }
                            }
                        }
                    }
                }
            }
            if (time == k)
                break;
            time++;
        }
        func();

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < answer.length; i++) {
            for (int j = 0; j < answer[0].length; j++){
                sb.append(answer[i][j]);
            }
            sb.append("\n");
        }
        System.out.println(sb.toString());
    }

    private static void func() {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                if (arr[i][j] != -1)
                    answer[i][j] = "O";
                else
                    answer[i][j] = ".";
            }
        }
    }
}
