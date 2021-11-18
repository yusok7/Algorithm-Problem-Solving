package baekjoon.silver.silver1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Baekjoon16953 {

    static class Value {
        String num;
        long count;

        public Value(String num, long count) {
            this.num = num;
            this.count = count;
        }

        public String getNum() {
            return num;
        }

        public long getCount() {
            return count;
        }
    }

    public static Queue<Value> queue = new LinkedList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        long a = Long.parseLong(st.nextToken());
        long b = Long.parseLong(st.nextToken());
        queue.add(new Value(String.valueOf(a), 1));

        while (!queue.isEmpty()) {
            Value poll = queue.poll();
            if (poll.getNum().equals(String.valueOf(b))) {
                System.out.println(poll.getCount());
                System.exit(0);
            }

            if (Long.parseLong(poll.getNum()+"1") <= b) {
                queue.add(new Value(poll.getNum()+"1", poll.getCount() + 1));
            }
            if (Long.parseLong(poll.getNum()) * 2 <= b ) {
                queue.add(new Value(String.valueOf(Long.parseLong(poll.getNum()) * 2), poll.getCount() + 1));
            }
        }

        System.out.println(-1);
    }
}
