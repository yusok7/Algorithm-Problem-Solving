package baekjoon.silver.silver5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Baekjoon1158 {

    public static Queue<Integer> queue = new LinkedList<>();
    public static List<Integer> list = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        for (int i = 1; i <= n; i++) {
            queue.add(i);
        }

        int count = 1;
        while (!queue.isEmpty()) {
            if (count == k) {
                Integer poll = queue.poll();
                list.add(poll);
                count = 1;
            } else {
                Integer poll = queue.poll();
                queue.add(poll);
                count++;
            }
        }

        StringBuilder sb = new StringBuilder();
        sb.append("<");
        for (int i = 0; i < list.size(); i++) {
            if (i != list.size() - 1) {
                sb.append(list.get(i)).append(",").append(" ");
            } else {
                sb.append(list.get(i)).append(">");
            }
        }
        System.out.println(sb.toString());
    }
}
