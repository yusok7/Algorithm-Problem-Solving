package programmers.kakao;

import java.util.*;

public class DartGame {

    public int solution(String dartResult) {
        int answer = 0;
        int a = 0;
        int b = 0;

        List<String> list = new ArrayList<>();
        List<Integer> result = new ArrayList<>();

        char[] arr = dartResult.toCharArray();
        boolean bool = false;
        for (int i = 1; i < arr.length; i++) {
            if (Character.isDigit(arr[i]) && bool == false) {
                bool = true;
                a = i;
            } else if (Character.isDigit(arr[i])) {
                b = i;
            }
        }

        list.add(dartResult.substring(0, a));
        list.add(dartResult.substring(a, b));
        list.add(dartResult.substring(b, dartResult.length()));

        int score = 0;
        for (int i = 0; i < 3; i++) {
            if (i == 0) {
                if (list.get(i).contains("10")) {
                    String[] split = new String[3];
                    split[0] = "10";
                    list.get(i).replaceAll("10", "");
                    String[] split1 = list.get(i).split("");
                    if (split1.length == 1) {
                        split[1] = split1[0];
                    } else {
                        split[1] = split1[0];
                        split[2] = split1[1];
                    }
                }
                String[] split = list.get(i).split("");
                if (split.length == 3) {
                    score = func(Integer.parseInt(split[0]), split[1], split[2]);
                    result.add(score);
                } else {
                    score = func(Integer.parseInt(split[0]), split[1], "");
                    result.add(score);
                }
            } else {
                String[] split = list.get(i).split("");
                if (split.length == 3) {
                    if (split[2].equals("*")) {
                        Integer num = result.get(i - 1);
                        result.set(i - 1, num * (2));
                    }
                    score = func(Integer.parseInt(split[0]), split[1], split[2]);
                    result.add(score);
                } else {
                    score = func(Integer.parseInt(split[0]), split[1], "");
                    result.add(score);
                }
            }
        }

        answer = result.stream()
                .mapToInt(Integer::intValue)
                .sum();

        return answer;
    }

    public int func(int num, String bonus, String option) {
        if (bonus.equals("S")) num = num;
        else if (bonus.equals("D")) num = num * num;
        else if (bonus.equals("T")) num = num * num * num;

        if (option.equals("*")) num = num * 2;
        else if (option.equals("#")) num = num * (-1);
        else num = num;

        return num;
    }
}
