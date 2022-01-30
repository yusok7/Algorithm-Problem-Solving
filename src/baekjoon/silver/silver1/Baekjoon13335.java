package baekjoon.silver.silver1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Baekjoon13335 {

    static class Truck {
        int weight;
        int time;

        public Truck(int weight, int time) {
            this.weight = weight;
            this.time = time;
        }
    }

    private static Queue<Truck> queue = new LinkedList<>();
    private static List<Integer> list = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int w = Integer.parseInt(st.nextToken()); // 다리 길이
        int l = Integer.parseInt(st.nextToken()); // 다리 최대 하중

        st = new StringTokenizer(br.readLine());
        while (st.hasMoreTokens()) {
            list.add(Integer.parseInt(st.nextToken()));
        }

        int time = 0;
        while (true) {
            // 시간 증가
            addTime();
            checkTime(w);

            // 다리 무게 측정
            if (!list.isEmpty()) {
                if (weightCheck(w, l, list.get(0))) {
                    Truck truck = new Truck(list.get(0), 1);
                    queue.add(truck);
                    list.remove(0);
                }
            }

            time++;

            if (list.size() == 0 && queue.isEmpty())
                break;
        }
        System.out.println(time);
    }

    private static boolean weightCheck(int w, int max, int newTruck) {
        if (queue.isEmpty())
            return true;
        if (queue.size() >= w)
            return false;
        int sum = 0;
        for (Truck truck : queue) {
            int weight = truck.weight;
            sum += weight;
        }
        if (sum + newTruck > max) {
            return false;
        }
        return true;
    }

    private static void addTime() {
        for (int i = 0; i < queue.size(); i++) {
            Truck truck = queue.poll();
            truck = new Truck(truck.weight, truck.time + 1);
            queue.add(truck);
        }
    }

    private static void checkTime(int w) {
        if (!queue.isEmpty()) {
            Truck truck = queue.peek();
            if (truck.time > w)
                queue.poll();
        }
    }
}
