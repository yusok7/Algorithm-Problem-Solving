package programmers.leveltwo;

import java.util.*;

public class BridgeTruck2 {

    private int answer = 0;
    private Queue<int[]> bridge = new LinkedList<>();
    private Queue<Integer> truck = new LinkedList<>();

    public int solution(int bridge_length, int weight, int[] truck_weights) {
        for (int val : truck_weights)
            truck.add(val);

        while(true) {
            // 시간 만료트럭 찾기
            if (!bridge.isEmpty()) {
                int[] arr = bridge.peek();
                if (arr[1] > bridge_length)
                    bridge.poll();
            }

            if(truck.isEmpty() && bridge.isEmpty())
                break;

            // 다리가 비어있고, 트럭이 대기중
            if (bridge.isEmpty() && !(truck.isEmpty())) {
                answer++;
                Integer truckWeight = truck.poll();
                bridge.add(new int[] {truckWeight, 1});
                continue;
            }

            // 다리에 트럭이 올라와 있고, 트럭이 대기중
            if (!(bridge.isEmpty()) && !(truck.isEmpty())) {
                answer++;
                int[] arr1 = bridge.peek();
                if (arr1[1] + 1 > bridge_length)
                    bridge.poll();
                int sum = 0;
                for (int i = 0; i < bridge.size(); i++) {
                    int[] arr = bridge.poll();
                    sum += arr[0];
                    arr[1] = arr[1] + 1;
                    bridge.add(arr);
                }
                if (sum + truck.peek() > weight)
                    continue;
                else {
                    Integer truckWeight = truck.poll();
                    bridge.add(new int[] {truckWeight, 1});
                    continue;
                }
            }

            // 다리에 트럭이 모두 올라온 상태
            if (!(bridge.isEmpty()) && truck.isEmpty()) {
                answer++;
                for (int i = 0; i < bridge.size(); i++) {
                    int[] arr = bridge.poll();
                    arr[1] = arr[1] + 1;
                    bridge.add(arr);
                }
            }
        }
        return answer;
    }
}
