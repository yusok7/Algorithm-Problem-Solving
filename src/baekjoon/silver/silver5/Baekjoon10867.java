package baekjoon.silver.silver5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Baekjoon10867 {

    public static Set<Integer> set = new HashSet<>();
    public static List<Integer> list = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            set.add(Integer.parseInt(st.nextToken()));
        }
        for (Integer val : set) {
            list.add(val);
        }
        Collections.sort(list);
        for (int i = 0 ; i < list.size(); i++) {
            System.out.print(list.get(i)+ " ");
        }
    }
}
