package programmers.kakao;

import java.util.*;

public class ParkingPrice {

    private static Map<String, Queue<String>> map = new HashMap<>();
    private static List<int[]> list = new ArrayList<>();

    public static void main(String[] args) {
        int[] fees = {120, 0, 60, 591};
        String[] records = {"16:00 3961 IN","16:00 0202 IN","18:00 3961 OUT","18:00 0202 OUT","23:58 3961 IN"};
        solution(fees, records);
    }

    public static int[] solution(int[] fees, String[] records) {
        for (String val : records) {
            String[] strArr = val.split(" ");
            String time = strArr[0];
            String num = strArr[1];
            if (map.containsKey(num)) {
                Queue<String> queue = map.get(num);
                queue.add(time);
                map.put(num, queue);
            }
            else {
                Queue<String> queue = new LinkedList<>();
                queue.add(time);
                map.put(num, queue);
            }
        }
        for (String key : map.keySet()) {
            Queue queue = map.get(key);
            if (queue.size() % 2 == 1)
                queue.add("23:59");
            int sum = 0;
            while(!queue.isEmpty()) {
                String s = String.valueOf(queue.poll());
                String e = String.valueOf(queue.poll());
                sum = sum + func(s, e);
            }
            list.add(new int[] {Integer.parseInt(key), sum});
        }
        Collections.sort(list, (int[] arr1, int[] arr2) -> {
            return Integer.compare(arr1[0], arr2[0]);
        });
        int index = 0;
        int[] answer = new int[list.size()];
        for (int[] arr : list) {
            answer[index] = func2(fees, arr[1]);
            index++;
        }
        return answer;
    }

    // 시간차이를 구해주는 함수
    private static int func(String s, String e) {
        StringBuilder sb = new StringBuilder();
        String[] arr = s.split(":");
        String str = sb.append(arr[0]).append(arr[1]).toString();
        int start = Integer.parseInt(str);
        sb.setLength(0);
        arr = e.split(":");
        str = sb.append(arr[0]).append(arr[1]).toString();
        int end = Integer.parseInt(str);

        int count = 0;
        while(true) {
            if (start == end)
                return count;
            count++;
            start = start + 1;
            if (start % 100 == 60) {
                start = start - 60;
                start = start + 100;
            }
        }
    }

    // 요금을 반환하는 함수
    private static int func2(int[] fees, int time) {
        int a1 = fees[0];
        int a2 = fees[1];
        int b1 = fees[2];
        int b2 = fees[3];
        if (time <= a1)
            return a1;
        int num = time - a1;
        if (num % b1 == 0)
            return a2 + (num / b1) * b2;
        else
            return a2 + ((num / b1) + 1) * b2;
    }
}
