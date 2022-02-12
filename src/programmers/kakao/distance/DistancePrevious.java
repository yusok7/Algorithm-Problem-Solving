package programmers.kakao.distance;

import java.util.LinkedList;
import java.util.Queue;

public class DistancePrevious {

    static class Node {
        int x;
        int y;
        int count;

        public Node(int x, int y, int count) {
            this.x = x;
            this.y = y;
            this.count = count;
        }
    }

    private static String[][] strArr = new String[5][5];
    private static boolean[][] boolArr = new boolean[5][5];

    // 북 동 남 서
    private static int[] dx = {0, 1, 0, -1};
    private static int[] dy = {-1, 0, 1, 0};

    private static Queue<Node> queue = new LinkedList<>();

    public static void main(String[] args) {
        String[][] places = {{"POOOP", "OXXOX", "OPXPX", "OOXOX", "POXXP"},
                {"POOPX", "OXPXP", "PXXXO", "OXXXO", "OOOPP"},
                {"PXOPX", "OXOXP", "OXPOX", "OXXOP", "PXPOX"},
                {"OOOXX", "XOOOX", "OOOXX", "OXOOX", "OOOOO"},
                {"PXPXP", "XPXPX", "PXPXP", "XPXPX", "PXPXP"}};
        int[] solution = solution(places);
        for (int i : solution) {
            System.out.println(i);
        }
    }

    public static int[] solution(String[][] places) {
        int[] answer = new int[5];

        int index = 0;
        for (String[] place : places) {

            for (int i = 0; i < place.length; i++) {
                String[] split = place[i].split("");
                for (int j = 0; j < split.length; j++) {
                    strArr[i][j] = split[j];
                }
            }

            boolean bool = false;
            for (int i = 0; i < 5; i++) {
                for (int j = 0; j < 5; j++) {
                    if (strArr[i][j].equals("P")) {
                       Node node = new Node(i, j, 0);
                        queue.add(node);
                        boolArr[i][j] = true;
                        while (!queue.isEmpty()) {
                            Node poll = queue.poll();
                            int x = poll.x;
                            int y = poll.y;
                            int count = poll.count;
                            if (count == 2) continue;
                            for (int a = 0; a < 4; a++) {
                                int nx = x + dx[a];
                                int ny = y + dy[a];
                                if (nx < 0 || ny < 0 || nx >= 5 || ny >= 5)
                                    continue;
                                if (boolArr[nx][ny] == true || strArr[nx][ny].equals("X"))
                                    continue;
                                if (strArr[nx][ny].equals("P")) {
                                    bool = true;
                                    break;
                                }
                                queue.add(new Node(nx, ny, count + 1));
                                boolArr[nx][ny] = true;
                            }
                            if (bool) {
                                break;
                            }
                        }
                        if (bool) {
                            break;
                        }
                    }
                    reset();
                }
                if (bool) {
                    break;
                }
            }
            if (bool) {
                answer[index] = 0;
            } else
                answer[index] = 1;
            index++;
        }
        return answer;
    }

    private static void reset() {
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                boolArr[i][j] = false;
            }
        }
    }
}
