package baekjoon.silver.silver4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Baekjoon13305 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] road = new int[n-1]; // 거리
        int[] price = new int[n-1]; // 가격

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < road.length; i++) {
            road[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < price.length; i++) {
            price[i] = Integer.parseInt(st.nextToken());
        }

        int oilPrice = price[0];
        int answer = 0;
        for (int i = 0; i < road.length; i++) {
            if (oilPrice > price[i]) {
                oilPrice = price[i];
            }

            answer += oilPrice * road[i];
        }
        System.out.println(answer);
    }
}
