package baekjoon.bronze.bronze2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Baekjoon1551 {

    public static void main(String[] args) throws IOException {
        List<Integer> list = new ArrayList<>();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        if (k == 0) {
            String str = br.readLine();
            System.out.println(str);
            System.exit(0);
        }

        st = new StringTokenizer(br.readLine(), ",");
        while (st.hasMoreTokens())
            list.add(Integer.parseInt(st.nextToken()));;

        for (int i = 0; i < k; i++) {
            List<Integer> copy = new ArrayList<>();
            for (int j = 0; j < list.size() - 1; j++) {
                copy.add(list.get(j + 1) - list.get(j));
            }
            list.clear();
            for (int j = 0; j < copy.size(); j++) {
                list.add(copy.get(j));
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < list.size(); i++) {
            if (i == list.size() - 1) {
                sb.append(list.get(i));
            } else {
                sb.append(list.get(i)).append(",");
            }
        }
        System.out.println(sb.toString());
    }
}
