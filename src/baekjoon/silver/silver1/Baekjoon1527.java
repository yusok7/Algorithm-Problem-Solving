package baekjoon.silver.silver1;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Baekjoon1527 {

    public static Queue<String> queue = new LinkedList<>();
    public static Map<Integer, Integer> map = new HashMap<>();
    public static List<Integer> list = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        func();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        int answer = 0;

        for (Integer val : map.keySet()) {
            list.add(val);
        }
        Collections.sort(list);

        for (Integer val : list) {
            if (val > b) break;
            if (a <= val && val <= b) answer++;
        }
        System.out.println(answer);
    }

    public static void func() {
        queue.add("4");
        queue.add("7");
        map.put(4, 0);
        map.put(7, 0);
        while (!queue.isEmpty()) {
            String str = queue.poll();
            String str1 = str + "4";
            String str2 = str + "7";
            if (Long.parseLong(str1) > 1000000000) continue;
            else {
                queue.add(str1);
                map.put(Integer.parseInt(str1), 0);
            }
            if (Long.parseLong(str2) > 1000000000) continue;
            else {
                queue.add(str2);
                map.put(Integer.parseInt(str2), 0);
            }
        }
    }
}
