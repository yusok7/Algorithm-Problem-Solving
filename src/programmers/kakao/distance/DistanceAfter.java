package programmers.kakao.distance;

import java.util.LinkedList;
import java.util.Queue;

public class DistanceAfter {

    public int[] solution(String[][] places) {
        int[] answer = new int[places.length];

        for (int i = 0; i < places.length; i++) {
            String[] strArr = places[i];

            boolean isOk = true;
            for (int r = 0; i < 5 && isOk; r++) {
                for (int c = 0; c < 5 && isOk; c++) {
                    if (strArr[r].charAt(c) == 'P') {
                        if (!bfs(r, c, strArr))
                            isOk = false;
                    }
                }
            }
            answer[i] = isOk ? 1 : 0;
        }

        return answer;
    }

    private boolean bfs(int r, int c, String[] strArr) {
        int dr[] = { -1, 1, 0, 0 };
        int dc[] = { 0, 0, -1, 1 };

        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[] {r, c});

        while (!queue.isEmpty()) {
            int[] position = queue.poll();

            for (int i = 0; i < 4; i++) {
                int nr = position[0] + dr[i];
                int nc = position[1] + dc[i];

                if (nr < 0 || nc < 0 || nr >= 5 || nc >= 5 || (nr == r && nc == c))
                    continue;

                int d = Math.abs(nr - r) + Math.abs(nc - c);

                if (strArr[nr].charAt(nc) == 'P' && d <= 2)
                    return false;
                else if (strArr[nr].charAt(nc) == 'O' && d < 2)
                    queue.offer(new int[] { nr, nc });
            }
        }
        return true;
    }
}
