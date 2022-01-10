package baekjoon.silver.silver3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Baekjoon13414 {

    static class Node {
        String number;
        int count;

        public Node(String number, int count) {
            this.number = number;
            this.count = count;
        }

        public String getNumber() {
            return number;
        }

        public int getCount() {
            return count;
        }
    }

    public static Map<String, Node> map = new HashMap<>();
    public static List<Node> list = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int k = Integer.parseInt(st.nextToken());
        int l = Integer.parseInt(st.nextToken());

        for (int i = 0; i < l; i++) {
            String str = br.readLine();
            Node node = new Node(str, i);
            map.put(str, node);
        }

        for (String val : map.keySet()) {
            Node node = map.get(val);
            list.add(node);
        }

        Collections.sort(list, (Node node1, Node node2) -> {
            return node1.getCount() - node2.getCount();
        });

        StringBuilder sb = new StringBuilder();
        if (list.size() < k) {
            k = list.size();
        }
        for (int i = 0; i < k; i++) {
            sb.append(list.get(i).getNumber()).append("\n");
        }
        System.out.println(sb.toString());
    }
}
