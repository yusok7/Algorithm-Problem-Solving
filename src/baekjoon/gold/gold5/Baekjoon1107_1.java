package baekjoon.gold.gold5;

import java.util.*;
import java.io.*;

public class Baekjoon1107_1 {

    private static int min;
    private static int number;
    private static List<Integer> list = new ArrayList<>();
    private static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        number = Integer.parseInt(br.readLine());
        int n = Integer.parseInt(br.readLine());

        if (n == 0) {
            int answer = Math.min(Math.abs(100 - number), String.valueOf(number).length());
            System.out.println(answer);
            System.exit(0);
        }

        String input = br.readLine();
        if (number == 100) {
            System.out.println(0);
            System.exit(0);
        }

        int length = 7;
        arr = new int[length];

        for (int i = 0; i < 10; i++) {
            if (!input.contains(String.valueOf(i)))
                list.add(i);
        }

        min = Math.abs(number - 100);
        dfs(0, length);
        System.out.println(min);
    }

    private static void dfs(int depth, int length) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < depth; i++)
            sb.append(arr[i]);
        if (sb.toString().length() != 0) {
            int num = Integer.parseInt(sb.toString());
            min = Math.min(min, Math.abs(number - num) + String.valueOf(num).length());
        }

        if (depth == length) {
            return;
        }

        for (int i = 0; i < list.size(); i++) {
            arr[depth] = list.get(i);
            dfs(depth + 1, length);
        }
    }
}
