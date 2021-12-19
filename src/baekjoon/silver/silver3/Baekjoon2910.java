package baekjoon.silver.silver3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Baekjoon2910 {

    static class Point {
        int count;
        int location;

        public Point(int count, int location) {
            this.count = count;
            this.location = location;
        }

        public int getCount() {
            return count;
        }

        public int getLocation() {
            return location;
        }
    }

    public static Map<Integer, Point> map = new HashMap<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());

        int[][] arr = new int[n][3];

        for (int i = 0; i < n; i++) {
            int number = Integer.parseInt(st.nextToken()); // 주어진 숫자
            int count = map.getOrDefault(number, new Point(0, 0)).getCount(); // 총 등장한 횟수
            int location = map.getOrDefault(number, new Point(0, 0)).getLocation(); // 위치
            if (location == 0 && count == 0) {
                location = i;
            }
            map.put(number, new Point(count + 1, location));
        }

        int index = 0;
        for (Integer val : map.keySet()) {
            Point point = map.get(val);
            int number = val;
            int count = point.getCount();
            int location = point.getLocation();
            for (int i = 0; i < count; i++) {
                arr[index][0] = number;
                arr[index][1] = count;
                arr[index][2] = location;
                index++;
            }
        }

        Arrays.sort(arr, (int[] a1, int[] a2) -> {
            if (a1[1] != a2[1]) {
                return -(a1[1] - a2[1]);
            } else {
                return (a1[2] - a2[2]);
            }
        });

        for (int i = 0; i < n; i++) {
            System.out.print(arr[i][0] + " ");
        }
    }
}
