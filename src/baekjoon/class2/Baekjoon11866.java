package baekjoon.class2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Baekjoon11866 {
    public static void main(String[] args) throws IOException {

        List<Integer> list = new ArrayList<>();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        Queue<Integer> queue = new LinkedList<>();
        for (int i = 1; i <= n; i++) {
            queue.add(i);
        }

        while (!queue.isEmpty()) {
            for (int i = 0; i < k; i++) {
                if (i == k-1) {
                    Integer poll = queue.poll();
                    list.add(poll);
                } else {
                    Integer poll = queue.poll();
                    queue.add(poll);
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        sb.append("<");

        for (int i = 0; i < list.size(); i++) {
            if (i == list.size() -1) {
                sb.append(list.get(i));
                sb.append(">");
            } else {
                sb.append(list.get(i));
                sb.append(", ");
            }
        }
        System.out.println(sb);
    }
}
