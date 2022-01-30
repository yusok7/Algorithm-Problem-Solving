package baekjoon.silver.silver1;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Baekjoon14891 {

    private static ArrayList<ArrayList<Integer>> list = new ArrayList<>();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for (int i = 0; i < 5; i++) {
            if (i == 0) {
                list.add(new ArrayList<>());
                continue;
            }
            list.add(new ArrayList<>());
            String[] strArr = br.readLine().split("");
            for (String val : strArr) {
                int num = Integer.parseInt(val);
                list.get(i).add(num);
            }
        }

        int k = Integer.parseInt(br.readLine());

        for (int i = 0; i < k; i++) {
            int[] arr = new int[5];
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n1 = Integer.parseInt(st.nextToken());
            int n2 = n1;
            int m1 = Integer.parseInt(st.nextToken());

            arr[n1] = m1;

            while (n1 + 1 <= 4) {
                if (list.get(n1).get(2) != list.get(n1 + 1).get(6))
                    arr[n1 + 1] = (-1) * arr[n1];
                else
                    break;
                n1 = n1 + 1;
            }

            while (n2 - 1 > 0) {
                if (list.get(n2 - 1).get(2) != list.get(n2).get(6))
                    arr[n2 - 1] = (-1) * arr[n2];
                else
                    break;
                n2 = n2 - 1;
            }

            for (int j = 1; j <= 4; j++) {
                if (arr[j] == 0)
                    continue;
                else
                    func(j, arr[j]);
            }
        }

        int result = 0;
        if (list.get(1).get(0) == 1) result++;
        if (list.get(2).get(0) == 1) result += 2;
        if (list.get(3).get(0) == 1) result += 4;
        if (list.get(4).get(0) == 1) result += 8;

        System.out.println(result);
    }

    private static void func(int index, int rotation) {
        if (rotation == 1) {
            int lastNum = list.get(index).get(7);
            list.get(index).remove(7);
            list.get(index).add(0, lastNum);
        } else if (rotation == -1) {
            int firstNum = list.get(index).get(0);
            list.get(index).remove(0);
            list.get(index).add(7, firstNum);
        }
    }
}
