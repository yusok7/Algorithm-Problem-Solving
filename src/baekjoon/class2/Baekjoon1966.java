package baekjoon.class2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Baekjoon1966 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int testCase = Integer.parseInt(br.readLine());

        for (int i = 0; i < testCase; i++) {

            Queue<Integer> queue = new LinkedList<>();
            Queue<Boolean> booleans = new LinkedList<>();

            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());
            int count = 1;

            for (int j = 0; j < n; j++) {
                if (j == m) {
                    booleans.add(Boolean.TRUE);
                } else {
                    booleans.add(Boolean.FALSE);
                }
            }
            if (n == 1) {
                br.readLine();
                System.out.println(1);
            } else {
                st = new StringTokenizer(br.readLine(), " ");
                for (int a = 0; a < n; a++) {
                    queue.add(Integer.parseInt(st.nextToken()));
                }

                // 답을 찾을때까지 반복
                while(true) {
                    int index = 0;
                    Boolean poll2 = Boolean.FALSE;
                    for (Integer priority : queue) {
                        Integer peek = queue.peek();
                        // 뒤에 우선순위가 더 높은것이 있다면은
                        if (priority > peek) {
                            Integer poll = queue.poll();
                            queue.add(poll);
                            Boolean boolPoll = booleans.poll();
                            booleans.add(boolPoll);
                            index++;
                            break;
                        }
                    }
                    if (index == 0){ // 우선순위가 더 높은 것이 없다면은
                        queue.remove();
                        poll2 = booleans.poll();
                        if (poll2 == Boolean.TRUE) {
                            System.out.println(count);
                        }
                        count++;
                    }
                    if (poll2 == Boolean.TRUE) {
                        break;
                    }
                }
            }
        }
    }
}
