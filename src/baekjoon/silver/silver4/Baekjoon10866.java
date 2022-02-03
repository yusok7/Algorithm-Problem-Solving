package baekjoon.silver.silver4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;

public class Baekjoon10866 {

    public static void main(String[] args) throws IOException {
        LinkedList<Integer> deque = new LinkedList<>();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        for (int i = 0; i < n; i++) {
            String[] strArr = br.readLine().split(" ");
            String str1 = "";
            String str2 = "";
            if (strArr.length == 2) {
                str1 = strArr[0];
                str2 = strArr[1];
            } else
                str1 = strArr[0];

            if (str1.equals("front")) {
                if (deque.size() <= 0)
                    System.out.println(-1);
                else
                    System.out.println(deque.peekFirst());
                continue;
            } else if (str1.equals("back")) {
                if (deque.size() <= 0)
                    System.out.println(-1);
                else
                    System.out.println(deque.peekLast());
                continue;
            } else if (str1.equals("empty")) {
                if (deque.size() == 0)
                    System.out.println(1);
                else
                    System.out.println(0);
                continue;
            } else if (str1.equals("size")) {
                System.out.println(deque.size());
                continue;
            } else if (str1.equals("push_front")) {
                deque.addFirst(Integer.parseInt(str2));
            } else if (str1.equals("push_back")) {
                deque.addLast(Integer.parseInt(str2));
            } else if (str1.equals("pop_front")) {
                if (deque.size() <= 0)
                    System.out.println(-1);
                else
                    System.out.println(deque.pollFirst());
            } else if (str1.equals("pop_back")) {
                if (deque.size() <= 0)
                    System.out.println(-1);
                else
                    System.out.println(deque.pollLast());
            }

        }
    }
}
