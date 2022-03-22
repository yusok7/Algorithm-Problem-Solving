package baekjoon.silver.silver4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Baekjoon1347 {

    static class Node implements Comparable<Node> {
        int x;
        int y;

        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public int compareTo(Node o) {
            return Integer.compare(this.x, o.x);
        }
    }

    private static int direction = 0;
    private static int row, col, colMax, colMin;

    // 남 동 북 서
    private static int[] dx = {1, 0, -1, 0};
    private static int[] dy = {0, 1, 0, -1};

    private static List<Node> list = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        row = col = colMax = colMin = 0;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        String str = br.readLine();

        list.add(new Node(0, 0));
        for (int i = 0; i < t; i++) {
            String s = String.valueOf(str.charAt(i));
            if (s.equals("R"))
                turnRight();
            else if (s.equals("L"))
                turnLeft();
            else {
                if (direction == 0) {
                    row++;
                    list.add(new Node(row, col));
                } else if (direction == 1) {
                    col++;
                    colMax = Math.max(colMax, col);
                    list.add(new Node(row, col));
                } else if (direction == 2) {
                    row--;
                    list.add(new Node(row, col));
                } else if (direction == 3) {
                    col--;
                    colMin = Math.min(colMin, col);
                    list.add(new Node(row, col));
                }
            }
        }
        Collections.sort(list);

        int num = list.get(0).x;
        int count = 0;
        if (num != 0) {
            count = 1;
            while (true) {
                num = num + 1;
                if (num == 0)
                    break;
                count++;
            }
        }
        row = list.get(list.size() - 1).x + count;

        int count2 = 0;
        if (colMin != 0) {
            count2 = 1;
            while (true) {
                colMin = colMin + 1;
                if (colMin == 0)
                    break;
                count2++;
            }
        }
        colMax = colMax + count2;
        String[][] arr = new String[row + 1][colMax + 1];

        for (Node node : list) {
            int x = node.x + count;
            int y = node.y + count2;
            arr[x][y] = ".";
        }

        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                if (arr[i][j] == null)
                    arr[i][j] = "#";
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                sb.append(arr[i][j]);
            }
            sb.append("\n");
        }
        System.out.println(sb.toString());
    }

    private static void turnLeft() {
        direction++;
        if (direction > 3)
            direction = 0;
    }

    private static void turnRight() {
        direction--;
        if (direction < 0)
            direction = 3;
    }
}
