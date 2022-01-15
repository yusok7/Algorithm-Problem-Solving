package baekjoon.silver.silver3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Baekjoon17204 {

    public static List<ArrayList<Integer>> graph = new ArrayList<>();
    public static boolean[] bool;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        // 초기화
        bool = new boolean[n];
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < n; i++) {
            int num = Integer.parseInt(br.readLine());
            graph.get(i).add(num);
        }

        int count = 0;
        int num = graph.get(0).get(0); // 초기 시작 값
        bool[0] = true;

        while (true) {
            if (num == k) {
                System.out.println(count + 1);
                System.exit(0);
            }

            if (bool[num] == true) {
                System.out.println(-1);
                break;
            } else {
                count++;
                bool[num] = true;
                num = graph.get(num).get(0);
            }
        }
    }
}
