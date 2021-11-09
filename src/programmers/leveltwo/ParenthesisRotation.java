package programmers.leveltwo;

import java.util.ArrayList;
import java.util.List;

public class ParenthesisRotation {

    public static void main(String[] args) {
        String s = "[](){}";
        solution(s);
    }

    public static int solution(String s) {
        int answer = -1;
        int count = 0;
        String[] strArr = s.split("");

        List<String> list = new ArrayList<>();
        for (int i = 0; i < strArr.length; i++) {
            list.add(strArr[i]);
        }

        for (int i = 0; i < list.size(); i++) {
            for (int j = 0; j < list.size(); j++) {
                String str = list.get(j);
                if (str.equals("(") || str.equals("{") || str.equals("[")) {
                    count ++;
                } else {
                    count --;
                }
                if (count < 0) {
                    break;
                }
            }

            if (count == 0) {
                answer ++;
            }

            String str = list.get(0);
            list.remove(0);
            list.add(str);
            count = 0;
        }

        return answer;
    }
}
