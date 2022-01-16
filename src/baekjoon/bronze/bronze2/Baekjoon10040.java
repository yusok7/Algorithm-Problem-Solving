package baekjoon.bronze.bronze2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Baekjoon10040 {

    static class Node {
        int seq; // 순서
        int price;
        int count;

        public Node(int seq, int price, int count) {
            this.seq = seq;
            this.price = price;
            this.count = count;
        }

        public int getSeq() {
            return seq;
        }

        public int getPrice() {
            return price;
        }

        public int getCount() {
            return count;
        }
    }

    public static List<Node> list = new ArrayList<>();
    public static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        arr = new int[m];

        for (int i = 0; i < n; i++) {
            int price = Integer.parseInt(br.readLine());
            Node node = new Node(i + 1, price, 0);
            list.add(node);
        }

        for (int i = 0; i < m; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        for (int val : arr) {
            for (int i = 0; i < list.size(); i++) {
                Node node = list.get(i);
                int seq = node.getSeq();
                int price = node.getPrice();
                int count = node.getCount();
                if (val >= price) {
                    node = new Node(seq, price, count + 1);
                    list.set(i, node);
                    break;
                }
            }
        }

        Collections.sort(list, (Node node1 , Node node2) -> {
            return -(Integer.compare(node1.getCount(), node2.getCount()));
        });

        System.out.println(list.get(0).getSeq());

    }
}
