package baekjoon.silver.silver4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Baekjoon1063 {

    static class Position {
        int x;
        int y;

        public Position(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    private static String[] arr = {"R", "L", "B", "T", "RT", "LT", "RB", "LB"};

    private static int[] dx = {0, 0, -1, 1, 1, 1, -1, -1};
    private static int[] dy = {1, -1, 0, 0, 1, -1, 1, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        List<String> list = Arrays.asList(arr);

        char[] kingArr = st.nextToken().toCharArray();
        int x = Integer.parseInt(String.valueOf(kingArr[1]));
        int y = (int)kingArr[0] - 64;
        Position king = new Position(x, y);

        char[] stoneArr = st.nextToken().toCharArray();
        x = Integer.parseInt(String.valueOf(stoneArr[1]));
        y = (int)stoneArr[0] - 64;
        Position stone = new Position(x, y);

        int k = Integer.parseInt(st.nextToken());

        for (int i = 0; i < k; i++) {
            String str = br.readLine();
            int index = list.indexOf(str);
            int kingX = king.x;
            int kingY = king.y;
            int nxKing = kingX + dx[index];
            int nyKing = kingY + dy[index];

            // 킹이 움직이는 곳에 돌이 있을 경우
            if (nxKing == stone.x && nyKing == stone.y) {
                int nxStone = stone.x + dx[index];
                int nyStone = stone.y + dy[index];
                if (nxKing < 1 || nxKing > 8 || nyKing < 1 || nyKing >8 || nxStone < 1 || nxStone > 8 || nyStone < 1 || nyStone > 8)
                    continue;
                else {
                    king = new Position(nxKing, nyKing);
                    stone = new Position(nxStone, nyStone);
                    continue;
                }
            }

            if (nxKing < 1 || nxKing > 8 || nyKing < 1 || nyKing >8)
                continue;
            king = new Position(nxKing, nyKing);
        }

        String result1 = String.valueOf((char) (king.y + 64)) + String.valueOf(king.x);
        String result2 = String.valueOf((char) (stone.y + 64)) + String.valueOf(stone.x);
        System.out.println(result1);
        System.out.println(result2);

    }

}
