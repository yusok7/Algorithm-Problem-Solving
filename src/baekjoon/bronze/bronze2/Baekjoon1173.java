package baekjoon.bronze.bronze2;

import java.util.*;
import java.io.*;

public class Baekjoon1173 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n, min, max, t, r, time;

        n = Integer.parseInt(st.nextToken());
        min = Integer.parseInt(st.nextToken());
        max = Integer.parseInt(st.nextToken());
        t = Integer.parseInt(st.nextToken());
        r = Integer.parseInt(st.nextToken());
        time = 0;

        if (min + t > max) {
            System.out.println(-1);
            System.exit(0);
        }

        int count = 0;
        int present = min;
        while (true) {
            if (count == n) {
                System.out.println(time);
                break;
            }
            // 운동
            if (present + t <= max) {
                present = present + t;
                count++; // 운동횟수 증가
                time++;  // 시간 증가
                continue;
            } else {
                present = present - r;
                if (present < min) {
                    present = min;
                }
                time++;
                continue;
            }
        }
    }
}
