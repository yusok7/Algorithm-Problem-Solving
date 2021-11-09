package programmers.leveltwo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MakeBigNumber {

    public static int n;
    public static int m;
    public static int[] arr;
    public static List<Integer> list = new ArrayList<>();

    public String solution(String number, int k) {
        String answer = "";
        int length = number.length();
        n = length;
        m = length - k;
        arr = new int[m];
        dfs(0,0,number);
        answer = String.valueOf(Collections.max(list));
        return answer;
    }

    public void dfs(int at, int depth, String number) {
        if (depth == m) {
            String[] strArr = number.split("");
            StringBuilder sb = new StringBuilder();
            for (int val : arr) {
                sb.append(strArr[val]);
            }
            list.add(Integer.parseInt(sb.toString()));
            return;
        }

        for (int i = at; i < n; i++) {
            arr[depth] = i;
            dfs(i+1, depth+1, number);
        }
    }
}
