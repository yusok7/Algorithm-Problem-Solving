package baekjoon.silver.silver4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Baekjoon2980 {

    private static Map<Integer, int[]> map = new HashMap<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken()); // 신호등의 개수
        int l = Integer.parseInt(st.nextToken()); // 도로의 길이

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int num = Integer.parseInt(st.nextToken());
            map.put(num, new int[] {Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())});
        }

        int time = 0;
        int length = 0;
        while (true) {
            time++;
            length++;
            if (length == l)
                break;
            if (map.containsKey(length)) {
                int[] arr = map.get(length);
                int red = arr[0];
                int green = arr[1];
                int sum = red + green;
                while (true) {
                    int num = time % sum;
                    if (num < red)
                        time++;
                    else if (num >= red)
                        break;
                }
            }
        }
        System.out.println(time);
    }
}
