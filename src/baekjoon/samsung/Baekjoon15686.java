package baekjoon.samsung;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Baekjoon15686 {

    public static int n;
    public static int m;
    public static int count;
    public static int[] combination;
    public static List<Node> home = new ArrayList<>();
    public static List<Node> chicken = new ArrayList<>();
    public static List<int[]> output = new ArrayList<>();

    static class Node {

        int x;
        int y;

        public Node(int x, int y) {
            super();
            this.x = x;
            this.y = y;
        }

        public int getX() {
            return x;
        }
        public int getY() {
            return y;
        }
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        combination = new int[m];

        int[][] arr = new int[n][n];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < n; j++) {
                int num = Integer.parseInt(st.nextToken());
                arr[i][j] = num;
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (arr[i][j] == 1) {
                    Node node = new Node(i, j);
                    home.add(node);
                }
                if (arr[i][j] == 2) {
                    Node node = new Node(i, j);
                    chicken.add(node);
                    count ++;
                }
            }
        }

        comb(0,0);

        int sum = 0;

        List<Integer> list3 = new ArrayList<>();

        // 치킨집 경우의 수 [[1번,2번,3번], [1번,2번,4번]...]
        for (int[] comb : output) {
            List<Integer> list2 = new ArrayList<>();
            // 각각의 집 [1번, 2번, 3번, 4번...]
            for (Node homeNode : home) {
                // 1번의 집에 대해서 모든 치킨집 거리 구하기
                List<Integer> list = new ArrayList<>();
                for (int i = 0; i < comb.length; i++) {
                    int index = comb[i];
                    Node chickenNode = chicken.get(index);
                    int distance = Math.abs(homeNode.x - chickenNode.x) + Math.abs(homeNode.y - chickenNode.y);
                    list.add(distance);
                }
                list2.add(Collections.min(list));
            }
            for(int a = 0; a < list2.size(); a++) {
                sum +=list2.get(a);
            }
            list3.add(sum);
            sum = 0;
        }

        System.out.println(Collections.min(list3));
    }

    public static void comb(int at, int depth) {

        // 종료조건
        if (depth == m) {
            int[] out = new int[m];
            for(int i = 0; i < m; i++) {
                out[i] = combination[i];
            }
            output.add(out);
            return;
        }

        for (int i = at; i < count; i++) {
            combination[depth] = i;
            comb(i+1, depth+1);
        }
    }

}