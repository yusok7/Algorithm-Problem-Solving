package programmers.kakao;

import java.util.ArrayList;
import java.util.List;

public class RecommendNewId {

    public String solution(String new_id) {
        String str = new_id;
        StringBuilder sb = new StringBuilder();
        String answer = "";

        // 1단계
        str = str.toLowerCase();
        // 2단계
        List<Character> list = new ArrayList<>();
        list.add('-');
        list.add('_');
        list.add('.');
        char[] chars = str.toCharArray();
        for (char c : chars) {
            if (Character.isDigit(c)) {
                sb.append(c);
            }
            if (Character.isLowerCase(c)) {
                sb.append(c);
            }
            if (list.contains(c)) {
                sb.append(c);
            }
        }
        str = sb.toString();

        // 3단계
        boolean bool = false;
        sb.setLength(0);
        char[] charArr = str.toCharArray();
        for (char c : charArr) {
            if (c != '.') {
                sb.append(c);
                bool = false;
            }
            if (c == '.' && bool == false) {
                sb.append(c);
                bool = true;
            }
        }
        str = sb.toString();

        // 4단계
        sb.setLength(0);
        String[] split = str.split("");
        for (int i = 0; i < split.length; i++) {
            if (i == 0 && split[i].equals(".")) continue;
            if (i == split.length -1 && split[i].equals(".")) continue;
            sb.append(split[i]);
        }
        str = sb.toString();

        // 5단계
        if (str.length() == 0) str = "a";

        // 6단계
        if (str.length() >= 16) {
            str = str.substring(0,15);
            if (str.substring(14).equals(".")) {
                str = str.substring(0,14);
            }
        }

        // 7단계
        if (str.length() <= 2) {
            if (str.length() == 1) {
                str = str + str + str;
            } else {
                String substring = str.substring(1);
                str += substring;
            }
        }
        return str;
    }
}
