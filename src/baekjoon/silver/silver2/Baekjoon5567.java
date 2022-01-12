package baekjoon.silver.silver2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Baekjoon5567 {

    public static ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
    public static boolean[] bool;
    public static int result = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());

        // 초기화 작업
        for (int i = 0; i < n + 1; i++) {
            graph.add(new ArrayList<>());
        }
        bool = new boolean[n + 1];

        for (int i = 0 ; i < m; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            graph.get(a).add(b);
            graph.get(b).add(a);
        }

        if (graph.get(1).size() == 0) {
            System.out.println(0);
            System.exit(0);
        }

        for (int i = 0; i < graph.get(1).size(); i++) {
            int num = graph.get(1).get(i);
            bool[num] = true;
            func(num);
        }

        for (boolean val : bool) {
            if (val) result++;
        }
        System.out.println(result - 1);

    }

    public static void func(int num) {
        for (int i = 0; i < graph.get(num).size(); i++) {
            int node = graph.get(num).get(i);
            bool[node] = true;
        }
    }
}
