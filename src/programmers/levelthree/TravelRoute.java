package programmers.levelthree;

import java.util.*;

public class TravelRoute {

    public static List<String> list = new ArrayList<>();

    public static void main(String[] args) {
        String[][] tickets = {{"ICN", "JFK"}, {"HND", "IAD"}, {"JFK", "HND"}};
        String[] solution = solution(tickets);
        for (String s : solution) {
            System.out.println("s = " + s);
        }
    }

    public static String[] solution(String[][] tickets) {

        int size = tickets.length + 1;
        String[] answer = new String[size];

        Arrays.sort(tickets, (String[] arr1, String[] arr2) -> {
            if (arr1[0].equals(arr2[0])) {
                return arr1[1].compareTo(arr2[1]);
            } else {
                return arr1[0].compareTo(arr2[0]);
            }
        });

        String start = "ICN";
        list.add(start);

        while (true) {
            for (String[] arr : tickets) {
                if (arr[0].equals(start) && !(arr[1].equals("-"))) {
                    list.add(arr[1]);
                    start = arr[1];
                    arr[1] = "-";
                    break;
                }
            }
            if (list.size() == size) break;
        }
        for (int i = 0; i < list.size() ; i++) {
            answer[i] = list.get(i);
        }

        return answer;
    }
}
