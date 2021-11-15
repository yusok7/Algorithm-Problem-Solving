package baekjoon.silver.silver1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Baekjoon9020 {

    public static boolean[] prime = new boolean[10001];
    public static Map<Integer,Integer> map = new HashMap<>();
    public static StringBuilder sb = new StringBuilder();
    public static List<Integer> list = new ArrayList<>();

    static class Result {
        int x;
        int y;

        public Result(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public int getX() {
            return x;
        }

        public int getY() {
            return y;
        }
    }

    public static void main(String[] args) throws IOException {
        isPrime();
        Result result = new Result(0, 10000);
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        for (Integer val : map.keySet()) {
            list.add(val);
        }
        Collections.sort(list);

        for (int i = 0; i < n; i++) {
            int input = Integer.parseInt(br.readLine());
            for (Integer val : list) {
                int x = val;
                int y = input - x;
                if (x > y) break;

                if (map.containsKey(y)) {
                    if (Math.abs(result.getX() - result.getY()) > Math.abs(x-y)) {
                        result = new Result(x, y);
                    }
                }
            }
            sb.append(result.getX()).append(" ").append(result.getY()).append("\n");
            result = new Result(0, 10000);
        }
        System.out.println(sb.toString());
    }

    public static void isPrime() {
        int n = 10000;
        prime[0] = prime[1] = true;
        for (int i = 2; i*i <= n; i++) {
            if (!prime[i]) {
                for (int j = i*i; j <= n; j += i) {
                    prime[j] = true;
                }
            }
        }

        for (int i = 0; i <= 10000; i++) {
            if (!prime[i]) map.put(i,i);
        }
    }

}
