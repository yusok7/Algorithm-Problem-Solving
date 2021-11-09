package baekjoon.silver.silver5;

import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.StringTokenizer;
import java.util.concurrent.ConcurrentHashMap;

public class Baekjoon11723 {
    public static ConcurrentHashMap<Integer, Integer> map = new ConcurrentHashMap<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());

        for (int i = 0; i < n; i++) {
            String str = br.readLine();

            if (str.startsWith("add")) {
                StringTokenizer st = new StringTokenizer(str);
                st.nextToken();
                int num = Integer.parseInt(st.nextToken());
                if (map.containsKey(num)) continue;
                else map.put(num, i);
            }

            if (str.startsWith("remove")) {
                StringTokenizer st = new StringTokenizer(str);
                st.nextToken();
                int num = Integer.parseInt(st.nextToken());
                if (!map.containsKey(num)) continue;
                else map.remove(num);
            }

            if (str.startsWith("check")) {
                StringTokenizer st = new StringTokenizer(str);
                st.nextToken();
                int num = Integer.parseInt(st.nextToken());
                if (map.containsKey(num)) {
                    bw.write("1");
                    bw.write("\n");
                }
                else {
                    bw.write("0");
                    bw.write("\n");
                }
            }

            if (str.startsWith("toggle")) {
                StringTokenizer st = new StringTokenizer(str);
                st.nextToken();
                int num = Integer.parseInt(st.nextToken());
                if (map.containsKey(num)) {
                    map.remove(num);
                }
                else {
                    map.put(num, i);
                }
            }

            if (str.startsWith("all")) {
                map.clear();
                for (int j = 1; j <= 20; j++) {
                    map.put(j,j);
                }
            }

            if (str.startsWith("empty")) {
                map.clear();
            }
        }
        bw.flush();
        bw.close();
        br.close();
    }
}
