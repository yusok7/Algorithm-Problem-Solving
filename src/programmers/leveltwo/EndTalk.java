package programmers.leveltwo;

import java.util.HashMap;
import java.util.Map;

public class EndTalk {

    public int[] solution(int n, String[] words) {
        Map<String,Integer> map = new HashMap<>();
        int[] answer = new int[2];
        int count = 1;
        boolean bool = true;
        String str = "";

        for (String val : words) {
            if (count == 1) {
                map.put(val, count);
                str = val.substring(val.length()-1);
                count++;
                continue;
            }
            if (!map.containsKey(val) && val.startsWith(str)) { // 포함하고 있지 않고, 올바른 대답
                map.put(val, count);
                str = val.substring(val.length()-1);
                count++;
            } else {
                if (count % n == 0) {
                    bool = false;
                    answer[0] = n;
                    answer[1] = count / n;
                    break;
                } else if (count % n != 0) {
                    bool = false;
                    answer[0] = count % n;
                    answer[1] = count / n + 1;
                    break;
                }
            }
        }
        if (bool) {
            answer[0] = 0;
            answer[1] = 0;
        }
        return answer;
    }
}
