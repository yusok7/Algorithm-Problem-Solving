package baekjoon.backtracking.permutation;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class PermutationTest {

    public static int[] arr;
    public static boolean[] visit;
    public static List<int[]> list = new ArrayList<>();
    public static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        arr = new int[m];
        visit = new boolean[n];

        dfs(n, m, 0);
        for(int[] arr : list) {
            for(int i = 0; i < m; i++) {
                if (i == m-1) System.out.println(arr[i]);
                else System.out.print(arr[i] + " ");
            }
        }
    }

    public static void dfs(int n, int m, int depth) {
        int[] output = new int[m];
        if (m == depth) {
            for(int i = 0; i < m; i++) {
                output[i] = arr[i];
            }
            list.add(output);
            return;
        }

        for(int i = 0; i < n; i++) {
            if(visit[i] == false) {
                visit[i] = true;
                arr[depth] = i+1;
                dfs(n,m,depth+1);
                visit[i] = false;
            }
        }
    }

}
