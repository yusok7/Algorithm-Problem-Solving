package baekjoon.gold.gold5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Baekjoon20055 {

    static class Node {
        int durability;
        boolean existence;

        public Node(int durability, boolean existence) {
            this.durability = durability;
            this.existence = existence;
        }
    }

    private static List<Node> list = new ArrayList<>();
    private static int answer = 1;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 2 * n; i++) {
            int durability = Integer.parseInt(st.nextToken());
            list.add(new Node(durability, false));
        }

        int size = list.size();
        int halfSize = size / 2;

        while (true) {
            // 1단계 벨트가 각 칸 위에 있는 로봇과 함께 한 칸 회전한다.
            Node node = list.get(size - 1);
            list.remove(size - 1);
            list.add(0, node);
            // 내리는 지점에 도착을 했나 확인
            check(halfSize - 1);

            // 2단계 가장 먼저 벨트에 올라간 로봇부터, 벨트가 회전하는 방향으로 한 칸 이동이 가능하다면 이동
            for (int i = halfSize - 2; i >= 0; i--) {
                // i번째 칸에 로봇이 존재한다면
                if (list.get(i).existence == true) {
                    // i + 1번째 칸에 로봇의 여부와 내구도 조사
                    if (list.get(i + 1).existence == false && list.get(i + 1).durability >= 1) {
                        // 옮길 수 있다면
                        list.set(i, new Node(list.get(i).durability, false));
                        list.set(i + 1, new Node(list.get(i + 1).durability - 1, true));
                        check(halfSize - 1);
                    }
                }
            }

            // 3단계 올리는 위치에 내구도가 0이 아니라면 올리는 위치에 로봇을 올린다.
            if (list.get(0).durability > 0)
                list.set(0, new Node(list.get(0).durability - 1, true));

            if (check2(k))
                break;
            answer++;
        }
        System.out.println(answer);
    }

    // 로봇이 내리는 지점에 도착했나 확인
    private static void check(int halfSize) {
        if (list.get(halfSize).existence == true)
            list.set(halfSize, new Node(list.get(halfSize).durability, false));
    }

    private static boolean check2(int k) {
        int count = 0;
        for (Node node : list) {
            if (node.durability == 0)
                count++;
        }
        if (count >= k)
            return true;
        return false;
    }
}
