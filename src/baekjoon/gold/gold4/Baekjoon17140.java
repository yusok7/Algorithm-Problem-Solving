package baekjoon.gold.gold4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Baekjoon17140 {

    static class Node implements Comparable<Node> {
        int key;
        int count;

        public Node(int key, int count) {
            this.key = key;
            this.count = count;
        }

        @Override
        public int compareTo(Node o) {
            if (this.count == o.count) {
                return Integer.compare(this.key, o.key);
            } else {
                return Integer.compare(this.count, o.count);
            }
        }
    }

    private static Map<Integer, Integer> map = new HashMap<>();
    private static List<Node> listNode = new ArrayList<>();
    private static List<String> list =new ArrayList<>();

    private static int[][] arr;
    private static int n;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int r = Integer.parseInt(st.nextToken()) - 1;
        int c = Integer.parseInt(st.nextToken()) - 1;
        int k = Integer.parseInt(st.nextToken());

        arr = new int[3][3];

        for (int i = 0; i < 3; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 3; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int time = 0;
        while (true) {
            if (arr.length > r && arr[0].length > c) {
                if (arr[r][c] == k)
                    break;
            }
            time++;
            if (time == 101) {
                System.out.println(-1);
                System.exit(0);
            }

            if (arr.length >= arr[0].length) {
                int length = arr.length;
                for (int i = 0; i < arr.length; i++) {
                    for (int val : arr[i]) {
                        map.put(val, map.getOrDefault(val, 0) + 1);
                    }
                    for (Integer key : map.keySet()) {
                        Node node = new Node(key, map.get(key));
                        listNode.add(node);
                    }
                    map.clear();
                    Collections.sort(listNode);
                    StringBuilder sb = new StringBuilder();
                    for (Node node : listNode) {
                        sb.append(node.key).append(node.count);
                    }
                    list.add(sb.toString());
                    listNode.clear();
                }
                List<String> list2 = new ArrayList<>();
                for (String val : list) {
                    list2.add(val);
                }
                Collections.sort(list, (String o1, String o2) -> {
                    return o1.length() - o2.length();
                });
                int size = list.get(list.size() - 1).length();
                arr = new int[length][size];
                for (int i = 0; i < length; i++) {
                    for (int j = 0; j < list2.get(i).length(); j++) {
                        arr[i][j] = Integer.parseInt(String.valueOf(list2.get(i).charAt(j)));
                    }
                }
                list.clear();
            } else {
                int row = arr.length;
                int col = arr[0].length;
                for (int a = 0; a < col; a++) { // 0, 1, 2, 3, 4, 5
                    for (int j = 0; j < row; j++) { // 0, 1, 2
                        int num = arr[j][a];
                        map.put(num, map.getOrDefault(num, 0) + 1);
                    }
                    for (Integer key : map.keySet()) {
                        Node node = new Node(key, map.get(key));
                        listNode.add(node);
                    }
                    map.clear();
                    Collections.sort(listNode);
                    StringBuilder sb = new StringBuilder();
                    for (Node node : listNode) {
                        sb.append(node.key).append(node.count);
                    }
                    list.add(sb.toString());
                    listNode.clear();
                }
                List<String> list2 = new ArrayList<>();
                for (String val : list) {
                    list2.add(val);
                }
                Collections.sort(list, (String o1, String o2) -> {
                    return o1.length() - o2.length();
                });
                int size = list.get(list.size() - 1).length();
                arr = new int[size][col];
                for (int i = 0; i < col; i++) { // 0, 1, 2, 3, 4, 5
                    for (int j = 0; j < list2.get(i).length(); j++) {
                        arr[j][i] = Integer.parseInt(String.valueOf(list2.get(i).charAt(j)));
                    }
                }
                list.clear();
            }
        }
        System.out.println(time);
    }
}
