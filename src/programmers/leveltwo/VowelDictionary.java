package programmers.leveltwo;

import java.util.HashMap;
import java.util.Map;

public class VowelDictionary {

    private static int count = 1;
    private static Map<String, Integer> map = new HashMap<>();
    private static String[] arr = new String[5];
    private static String[] alpha = {"A", "E", "I", "O", "U"};

    public static void main(String[] args) {
        int answer = solution("AAAAE");
        System.out.println(answer);
    }

    public static int solution(String word) {
        dfs(0);
        int answer = map.get(word);
        return answer;
    }

    private static void dfs(int depth) {
        if (depth == 5) {
            return;
        }

        for (int i = 0; i < 5; i++) {
            arr[depth] = alpha[i];
            StringBuilder sb = new StringBuilder();
            for (int j = 0; j <= depth; j++)
                sb.append(arr[j]);
            map.put(sb.toString(), count++);
            dfs(depth + 1);
        }
    }
}
