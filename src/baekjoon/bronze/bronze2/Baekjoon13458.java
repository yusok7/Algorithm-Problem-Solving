package baekjoon.bronze.bronze2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Baekjoon13458 {

    private static long result = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        String[] strArr = br.readLine().split(" ");
        int b = Integer.parseInt(strArr[0]);
        int c = Integer.parseInt(strArr[1]);

        List<Integer> list = new ArrayList<>();
        while (st.hasMoreTokens()) {
            int num = Integer.parseInt(st.nextToken()) - b;
            list.add(num);
            result++;
        }

        for (Integer val : list) {
            if (val <= 0)
                continue;
            long div = val / c;
            long rem = val % c;
            if (rem != 0)
                result += div + 1;
            else
                result += div;
        }
        System.out.println(result);
    }
}
