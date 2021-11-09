package programmers.levelone;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * https://programmers.co.kr/learn/courses/30/lessons/86051?language=java
 */

public class AddNumberNotExist {
    public static void main(String[] args) {
        long n = 118372;
        System.out.println(solution(n));
    }

    public static long solution(long n) {
        String str = String.valueOf(n);
        String[] strArr = str.split("");
        List<String> list = new ArrayList<>();
        for(int i = 0; i < strArr.length; i++) {
            list.add(strArr[i]);
        }
        Collections.sort(list);
        Collections.reverse(list);
        String str2 = "";
        for(int i = 0; i < strArr.length; i++) {
            str2 += list.get(i);
        }
        long answer = Long.parseLong(str);
        return answer;
    }
}
