package baekjoon.class2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Baekjoon1920 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        List<Integer> list1 = new ArrayList<>(n);
        for (int i = 0; i < n; i++) {
            list1.add(Integer.parseInt(st.nextToken()));
        }

        Collections.sort(list1);

        int m = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine(), " ");
        List<Integer> list2 = new ArrayList<>(m);
        for (int i = 0; i < n; i++) {
            list2.add(Integer.parseInt(st.nextToken()));
        }


        for (Integer val : list2) {
            if (list1.contains(val)) {
                System.out.println(1);
            } else System.out.println(0);
        }
    }
}
