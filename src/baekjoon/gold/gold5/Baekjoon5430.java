package baekjoon.gold.gold5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;

public class Baekjoon5430 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testCase = Integer.parseInt(br.readLine());

        for (int i = 0; i < testCase; i++) {
            LinkedList<Integer> queue = new LinkedList<>();
            String str = br.readLine();
            String[] strArr = str.split("");
            int n = Integer.parseInt(br.readLine());
            String number = br.readLine()
                    .replace("[", "")
                    .replace("]", "");
            if (!number.contains(",") && str.contains("D")) {
                System.out.println("error");
                continue;
            } else if (!number.contains(",") && !str.contains("D")) {
                System.out.println("[]");
                continue;
            }
            String[] num = number.split(",");
            for (String val : num) {
                queue.add(Integer.parseInt(val));
            }

            String location = "first";

            boolean bool = false;
            for (String val : strArr) {
                if (val.equals("R")) {
                    location = location.equals("first") ? "last" : "first";
                } else {
                    if (queue.size() == 0) {
                        bool = true;
                        break;
                    } else {
                        if (location.equals("first"))
                            queue.pollFirst();
                        else
                            queue.pollLast();
                    }
                }
            }
            if (bool) {
                System.out.println("error");
                continue;
            }

            if (queue.size() == 0) {
                System.out.println("[]");
                continue;
            }

            StringBuilder sb = new StringBuilder();
            sb.append("[");
            if (location.equals("first")) {
                while (!queue.isEmpty()) {
                    sb.append(queue.pollFirst()).append(",");
                }
            } else {
                while (!queue.isEmpty()) {
                    sb.append(queue.pollLast()).append(",");
                }
            }
            sb.deleteCharAt(sb.length() - 1);
            sb.append("]");
            System.out.println(sb.toString());
        }
    }
}
