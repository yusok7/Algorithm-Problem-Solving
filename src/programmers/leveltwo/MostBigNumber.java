package programmers.leveltwo;

import java.util.Arrays;

public class MostBigNumber {

    public StringBuilder sb = new StringBuilder();

    public String solution(int[] numbers) {
        String[] strArr = new String[numbers.length];
        for (int i = 0; i < numbers.length; i++) {
            strArr[i] = String.valueOf(numbers[i]);
        }

        /**
         *  이 부분이 문제의 핵심 (정렬)
         */
        Arrays.sort(strArr, (String o1, String o2) -> {
            return (o2+o1).compareTo(o1+o2);
        });

        for (String val : strArr) {
            sb.append(val);
        }
        if (sb.toString().startsWith("0")) return "0";
        return sb.toString();
    }
}
