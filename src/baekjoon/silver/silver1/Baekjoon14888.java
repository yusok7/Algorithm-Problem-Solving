package baekjoon.silver.silver1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Baekjoon14888 {

    private static LinkedHashSet<String> set = new LinkedHashSet<>();
    private static List<Integer> result = new ArrayList<>();
    private static List<Integer> list = new ArrayList<>();

    private static int[] arr;
    private static boolean[] visit;
    private static String[] operator;
    private static String[] per;

    private static int n;
    private static int m;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        m = n - 1;

        arr = new int[n];
        visit = new boolean[m];
        operator = new String[m];
        per = new String[m];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++)
            arr[i] = Integer.parseInt(st.nextToken());

        for (int i : arr)
            list.add(i);

        st = new StringTokenizer(br.readLine());
        int index = 0;
        for (int i = 0; i < 4; i++) {
            int num = Integer.parseInt(st.nextToken());
            if (num == 0)
                continue;
            for (int j = 0; j < num; j++) {
                operator[index++] = String.valueOf(i);
            }
        }

        func(0);

        for (String str : set) {
            int sum = 0;
            String[] strArr = str.split(" ");
            for (int i = 0; i < strArr.length; i++) {
                if (strArr[i].equals("0")) {
                    sum = list.get(0) + list.get(1);
                    func2(sum);
                } else if (strArr[i].equals("1")) {
                    sum = list.get(0) - list.get(1);
                    func2(sum);
                } else if (strArr[i].equals("2")) {
                    sum = list.get(0) * list.get(1);
                    func2(sum);
                } else {
                    if (list.get(0) < 0) {
                        int num = (-1) * list.get(0);
                        num = num / list.get(1);
                        list.remove(0);
                        list.remove(0);
                        list.add(0, (-1) * num);
                    } else {
                        sum = list.get(0) / list.get(1);
                        func2(sum);
                    }
                }
            }
            result.add(list.get(0));
            list.clear();
            for (int i : arr)
                list.add(i);
        }
        System.out.println(Collections.max(result));
        System.out.println(Collections.min(result));
    }

    private static void func(int depth) {
        if (depth == m) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < per.length; i++) {
                sb.append(per[i]).append(" ");
            }
            set.add(sb.toString());
            return;
        }

        for (int i = 0; i < m; i++) {
            if (!visit[i]) {
                visit[i] = true;
                per[depth] = operator[i];
                func(depth + 1);
                visit[i] = false;
            }
        }
    }

    private static void func2(int sum) {
        list.remove(0);
        list.remove(0);
        list.add(0, sum);
    }
}
