package doit.c3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class P2 {

    private static List<Double> list = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 0; i < n; i++) {
            list.add(Double.parseDouble(st.nextToken()));
        }
        double max = Collections.max(list);

        for (int i = 0; i < n; i++) {
            double num = list.get(i);
            list.set(i, num / max * 100);
        }

        double answer = 0;
        for (Double num : list) {
            answer += num;
        }
        System.out.println(answer / list.size());
    }
}
