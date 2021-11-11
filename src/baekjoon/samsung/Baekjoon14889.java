package baekjoon.samsung;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Baekjoon14889 {

    public static int[] comb;
    public static int[][] arr;
    public static List<Integer> list = new ArrayList<>();
    public static int n;
    public static int m;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        m = n / 2;
        comb = new int[m];
        arr = new int[n][n];

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine()," ");
            for (int j = 0; j < n; j++) {
                int num = Integer.parseInt(st.nextToken());
                arr[i][j] = num;
            }
        }

        combination(0,0);
        System.out.println(Collections.min(list));
    }

    public static void combination(int at, int depth) {
        if (depth == m) {
            int a = 0; // a팀
            int b = 0; // b팀
            int[] comb2 = new int[m];

            List<Integer> list2 = new ArrayList<>();
            for (int i : comb) {
                list2.add(i);
            }

            int index = 0;
            for (int i = 0; i < n; i++) {
                if (!list2.contains(i)) {
                    comb2[index] = i;
                    index++;
                }
            }

            for (int i = 0; i < comb.length-1; i++) {
                for (int j = i+1; j < comb.length; j++) {
                    a += arr[comb[i]][comb[j]];
                    a += arr[comb[j]][comb[i]];
                }
            }
            for (int i = 0; i < comb2.length-1; i++) {
                for (int j = i+1; j < comb2.length; j++) {
                    b += arr[comb2[i]][comb2[j]];
                    b += arr[comb2[j]][comb2[i]];
                }
            }
            list.add(Math.abs(a-b));
            return;
        }

        for (int i = at; i < n; i++) {
            comb[depth] = i;
            combination(i+1, depth+1);
        }
    }
}
