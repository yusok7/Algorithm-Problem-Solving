package baekjoon.silver.silver5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Baekjoon1331 {

    private static int[] dx = {1, 2, 2, 1, -1, -2, -2, -1};
    private static int[] dy = {2, 1, -1, -2, -2, -1, 1, 2};

    private static boolean[][] visit = new boolean[6][6];

    private static List<String> list = new ArrayList<>(Arrays.asList("A", "B", "C", "D", "E", "F"));
    private static List<String> move = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for (int i = 0; i < 36; i++)
            move.add(br.readLine());

        for (int i = 0; i < move.size(); i++) {
            String start = "";
            String end = "";

            if (i == move.size() - 1) {
                start = move.get(i);
                end = move.get(0);
            } else {
                start = move.get(i);
                end = move.get(i + 1);
            }

            String[] split = start.split("");
            int startX = list.indexOf(split[0]);
            int startY = Integer.parseInt(split[1]) - 1;

            split = end.split("");
            int endX = list.indexOf(split[0]);
            int endY = Integer.parseInt(split[1]) - 1;
            if (visit[endX][endY] == true) {
                System.out.println("Invalid");
                System.exit(0);
            }
            visit[endX][endY] = true;

            boolean bool = true;
            for (int j = 0; j < 8; j++) {
                int nx = startX + dx[j];
                int ny = startY + dy[j];
                if (nx == endX && ny == endY) {
                    bool = false;
                    break;
                }
            }

            if (bool) {
                System.out.println("Invalid");
                System.exit(0);
            }
        }
        System.out.println("Valid");
    }
}
