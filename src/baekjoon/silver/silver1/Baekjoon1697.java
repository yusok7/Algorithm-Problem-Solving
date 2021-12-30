package baekjoon.silver.silver1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Baekjoon1697 {

    static class Node {
        int index;
        int count;

        public Node(int index, int count) {
            this.index = index;
            this.count = count;
        }

        public int getIndex() {
            return index;
        }

        public int getCount() {
            return count;
        }
    }

    public static Queue<Node> queue = new LinkedList<>();
    public static boolean[] boolArr = new boolean[100001];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int start = Integer.parseInt(st.nextToken());
        int last = Integer.parseInt(st.nextToken());

        queue.add(new Node(start, 0));

        while (!queue.isEmpty()) {
            Node node = queue.poll();
            int index = node.getIndex();
            int count = node.getCount();
            boolArr[index] = true;

            if (index == last) {
                System.out.println(count);
                break;
            }

            for (int i = 0; i < 3; i++) {
                int num = index;
                if (i == 0) {
                    num = num - 1;
                    if (num < 0 || num > 100000 || boolArr[num]) continue;
                    else {
                        queue.add(new Node(num, count + 1));
                    }
                }
                if (i == 1) {
                    num = num + 1;
                    if (num < 0 || num > 100000 || boolArr[num]) continue;
                    else {
                        queue.add(new Node(num, count + 1));
                    }
                }
                if (i == 2) {
                    num = 2 * num;
                    if (num < 0 || num > 100000 || boolArr[num]) continue;
                    else {
                        queue.add(new Node(num, count + 1));
                    }
                }
            }
        }
    }
}
