package baekjoon.gold.gold5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;

public class Baekjoon5430 {

    private static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        for (int i = 0; i < t; i++) {
            boolean isFisrt = true;
            boolean bool = false;
            Deque<Integer> deque = new LinkedList<>();
            String[] strArr = br.readLine().split("");
            int n = Integer.parseInt(br.readLine());

            String str = br.readLine();
            str = str.replace("[", "");
            str = str.replace("]", "");
            String[] numbers = str.split(",");

            for (String number : numbers) {
                if (number.equals(""))
                    continue;
                deque.add(Integer.parseInt(number));
            }

            for (String val : strArr) {
                if (val.equals("R"))
                    isFisrt = !isFisrt;
                else if (val.equals("D")) {
                    if (deque.isEmpty()) {
                        sb.append("error").append("\n");
                        bool = true;
                        break;
                    } else {
                        if (isFisrt)
                            deque.pollFirst();
                        else
                            deque.pollLast();
                    }
                }
            }

            if (bool)
                continue;

            if (deque.isEmpty()) {
                sb.append("[]").append("\n");
                continue;
            }

            sb.append("[");
            int size = deque.size();
            for (int j = 0; j < size; j++) {
                if (isFisrt) {
                    if (j == size - 1) {
                        sb.append(deque.pollFirst()).append("]").append("\n");
                    } else {
                        sb.append(deque.pollFirst()).append(",");
                    }
                } else {
                    if (j == size - 1) {
                        sb.append(deque.pollLast()).append("]").append("\n");
                    } else {
                        sb.append(deque.pollLast()).append(",");
                    }
                }
            }
        }
        System.out.println(sb.toString());
    }
}
