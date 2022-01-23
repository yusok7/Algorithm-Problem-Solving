package programmers.kakao;

import java.util.*;

public class ReportResult {

    public static void main(String[] args) {
        String[] id_list = {"muzi", "frodo", "apeach", "neo"};
        String[] report = {"muzi frodo","apeach frodo","frodo neo","muzi neo","apeach muzi"};
        int k = 2;
        int[] solution = solution(id_list, report, k);
        for (int val : solution) {
            System.out.println(val);
        }
    }

    public static int[] solution(String[] id_list, String[] report, int k) {
        Map<String, Integer> map = new HashMap<>();
        int n = id_list.length;
        HashSet<Integer>[] s = new HashSet[n];
        for (int i = 0; i < n; i++) {
            s[i] = new HashSet<>();
        }

        int[] answer = new int[n];

        for (int i = 0; i < n; i++) {
            map.put(id_list[i], i);
        }

        for (String rep : report) {
            String[] idlist = rep.split(" ");
            Integer id1 = map.get(idlist[0]);
            Integer id2 = map.get(idlist[1]);
            s[id2].add(id1);
        }

        for (int i = 0; i < n; i++) {
            if (s[i].size() < k) continue;
            for (Integer val : s[i]) {
                answer[val]++;
            }
        }
        return answer;
    }
}
