package baekjoon.gold.gold4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baekjoon15685 {

    private static int[][] arr = new int[101][101];

    // 동 북 서 남
    private static int[] dy = {0, -1, 0, 1};
    private static int[] dx = {1, 0, -1, 0};

    // 오른쪽 아래 대각선
    private static int[] dy2 = {0, 1, 1};
    private static int[] dx2 = {1, 0, 1};

    private static int answer = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        for (int i = 0; i < t; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            arr[y][x] = 1;
            String d = st.nextToken();
            int g = Integer.parseInt(st.nextToken());

            String str = func(0, g, d);

            for (int j = 0; j < str.length(); j++) {
                int num = str.charAt(j) - '0';
                x = x + dx[num];
                y = y + dy[num];
                arr[y][x] = 1;
            }
        }

        // i 는 행 담당 행 : y
        for (int i = 0; i < 101; i++) {
            // j 는 열 담당
            for (int j = 0; j < 101; j++) {
                if (arr[i][j] == 1) {
                    for (int k = 0; k < 3; k++) {
                        int nx = j + dx2[k];
                        int ny = i + dy2[k];
                        if (nx < 0 || ny < 0 || nx >= 101 || ny >= 101)
                            break;
                        if (arr[ny][nx] != 1)
                            break;
                        if (k == 2)
                            answer++;
                    }
                }
            }
        }
        System.out.println(answer);
    }

    private static String func(int depth, int m, String str) {
        if (depth == m) {
            return str;
        }

        StringBuilder sb = new StringBuilder();
        String reverseStr = sb.append(str).reverse().toString();
        sb.setLength(0);

        for (int i = 0; i < reverseStr.length(); i++) {
            String s = String.valueOf(reverseStr.charAt(i));
            if (s.equals("0"))
                sb.append(1);
            else if (s.equals("1"))
                sb.append(2);
            else if (s.equals("2"))
                sb.append(3);
            else
                sb.append(0);
        }
        sb.insert(0, str);
        return func(depth + 1, m, sb.toString());
    }
}
