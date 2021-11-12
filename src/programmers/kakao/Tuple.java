package programmers.kakao;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Tuple {

    public int[] solution(String s) {
        List<String> list = new ArrayList<>();
        s = s.replace("{{", "");
        s = s.replace("}}", "");
        s = s.replace("},{", "-");
        String[] strArr = s.split("-");
        Arrays.sort(strArr, (String s1, String s2) -> {
            return s1.length() - s2.length();
        });
        int[] answer = new int[strArr.length];

        for (String val : strArr) {
            String[] arr = val.split(",");
            for (String val2 : arr) {
                if (list.contains(val2)) continue;
                else list.add(val2);
            }
        }

        for (int i = 0; i < list.size(); i++) {
            answer[i] = Integer.parseInt(list.get(i));
        }

        return answer;
    }
}
