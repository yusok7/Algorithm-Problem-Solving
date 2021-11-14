package baekjoon.gold.gold5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Baekjoon1759 {

    public static StringBuilder sb = new StringBuilder();
    public static int[] comb;
    public static String[] arr;
    public static int n;
    public static int m;
    public static List<String> vowel = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        m = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());
        comb = new int[m];
        arr = new String[n];
        vowel.add("a");
        vowel.add("e");
        vowel.add("i");
        vowel.add("o");
        vowel.add("u");

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = st.nextToken();
        }
        Arrays.sort(arr);

        combination(0,0);
        System.out.println(sb.toString());
    }

    public static void combination(int at, int depth) {
        List<String> list = new ArrayList<>();
        if (depth == m) {
            for (int i : comb) {
                list.add(arr[i]);
            }
            int count = 0; // 모음의 개수
            for (String val : list) {
                if (vowel.contains(val)) count++;
            }
            if (count == 0) return;
            if (m - count < 2) return;
            for (int i : comb) {
                sb.append(arr[i]);
            }
            sb.append("\n");
            return;
        }
        for (int i = at; i < n; i++) {
            comb[depth] = i;
            combination(i+1, depth+1);
        }
    }
}
