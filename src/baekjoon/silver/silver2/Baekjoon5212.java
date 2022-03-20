package baekjoon.silver.silver2;

import java.util.*;
import java.io.*;

public class Baekjoon5212 {

    private static String[][] arr;
    private static String[][] result;

    private static int start, end;

    // 북 동 남 서
    private static int[] dx = {-1, 0, 1, 0};
    private static int[] dy = {0, 1, 0, -1};

    private static List<Integer> list = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        start = 100;
        end = -1;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int r = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());

        arr = new String[r][c];
        result = new String[r][c];

        for (int i = 0; i < r; i++) {
            String str = br.readLine();
            for (int j = 0; j < c; j++) {
                arr[i][j] = String.valueOf(str.charAt(j));
            }
        }

        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if (arr[i][j].equals("."))
                    result[i][j] = ".";
                else {
                    int count = 0;
                    int x = i;
                    int y = j;
                    for (int k = 0; k < 4; k++) {
                        int nx = x + dx[k];
                        int ny = y + dy[k];
                        if (nx < 0 || ny < 0 || nx >= r || ny >= c) {
                            count++;
                            continue;
                        }
                        if (arr[nx][ny].equals("."))
                            count++;
                    }
                    if (count >= 3)
                        result[i][j] = ".";
                    else
                        result[i][j] = "X";
                }
            }
        }

        for (int i = 0; i < r; i++) {
            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < c; j++) {
                sb.append(result[i][j]);
            }
            String str = sb.toString();
            if (str.contains("X")) {
                list.add(i);
                start = Math.min(start, str.indexOf("X"));
                end = Math.max(end, str.lastIndexOf("X"));
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = Collections.min(list); i <= Collections.max(list); i++) {
            String[] strArr = result[i];
            for (int j = start; j <= end; j++) {
                sb.append(strArr[j]);
            }
            sb.append("\n");
        }
        System.out.println(sb.toString());
    }
}
