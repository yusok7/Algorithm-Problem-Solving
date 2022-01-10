package baekjoon.gold.gold5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Baekjoon5014 {

    static class Node {
        int number;
        int count;

        public Node(int number, int count) {
            this.number = number;
            this.count = count;
        }

        public int getNumber() {
            return number;
        }

        public int getCount() {
            return count;
        }
    }

    public static Queue<Node> queue = new LinkedList<>();
    public static boolean[] bool;

    public static int f,s,g,u,d;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        f = Integer.parseInt(st.nextToken());
        s = Integer.parseInt(st.nextToken());
        g = Integer.parseInt(st.nextToken());
        u = Integer.parseInt(st.nextToken());
        d = Integer.parseInt(st.nextToken());

        bool = new boolean[f + 1];

        queue.add(new Node(s, 0));
        bool[s] = true;

        while (!queue.isEmpty()) {
            Node node = queue.poll();
            int number = node.getNumber();
            int count = node.getCount();

            // 목표지점에 도달했다면
            if (number == g) {
                System.out.println(count);
                System.exit(0);
            }

            // 위로 올라가기
            int upNumber = number + u;
            if (upNumber <= f && bool[upNumber] == false) {
                queue.add(new Node(upNumber, count + 1));
                bool[upNumber] = true;
            }

            // 아래로 내려가기
            int downNumber = number - d;
            if (downNumber >= 1 && bool[downNumber] == false) {
                queue.add(new Node(downNumber, count + 1));
                bool[downNumber] = true;
            }
        }

        System.out.println("use the stairs");
    }
}
