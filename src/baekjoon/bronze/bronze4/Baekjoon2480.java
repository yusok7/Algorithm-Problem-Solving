package baekjoon.bronze.bronze4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Baekjoon2480 {
    
    static class Node {
        int num;
        int count;

        public Node(int num, int count) {
            this.num = num;
            this.count = count;
        }

        public int getNum() {
            return num;
        }

        public int getCount() {
            return count;
        }
    }
    
    public static Map<Integer, Integer> map = new HashMap<>();
    public static List<Node> list = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        while (st.hasMoreTokens()) {
            int num = Integer.parseInt(st.nextToken());
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        if (map.size() == 3) {
            int max = Collections.max(map.keySet());
            System.out.println(max * 100);
            System.exit(0);
        }

        for (Integer key : map.keySet()) {
            Node node = new Node(key, map.get(key));
            list.add(node);
        }

        Collections.sort(list, (Node node1, Node node2) -> {
            return -(Integer.compare(node1.getCount(), node2.getCount()));
        });

        Node node = list.get(0);
        if (node.getCount() == 2) {
            System.out.println(1000 + node.getNum() * 100);
        } else {
            System.out.println(10000 + node.getNum() * 1000);
        }
    }
}
