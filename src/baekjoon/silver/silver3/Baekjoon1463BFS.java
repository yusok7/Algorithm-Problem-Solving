package baekjoon.silver.silver3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Baekjoon1463BFS {

    private static boolean[] visit = new boolean[1000001];
    private static Queue<int[]> queue = new LinkedList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int x = Integer.parseInt(br.readLine());
        if (x == 1) {
            System.out.println(0);
            System.exit(0);
        } else {
            queue.add(new int[] {x, 0});
            visit[x] = true;
        }

        while (true) {
            int[] poll = queue.poll();
            int num = poll[0];
            int count = poll[1];

            if (num == 1) {
                System.out.println(count);
                break;
            }

            if (num % 3 == 0 && !(visit[num / 3])) {
                queue.add(new int[]{num / 3, count + 1});
                visit[num / 3] = true;
            }
            if (num % 2 == 0 && !(visit[num / 2])) {
                queue.add(new int[]{num / 2, count + 1});
                visit[num / 2] = true;
            }
            if (!visit[num - 1]) {
                queue.add(new int[]{num - 1, count + 1});
                visit[num - 1] = true;
            }
        }
    }
}
