package programmers.kakao;

import java.util.*;
public class SecretMap {
    public String[] solution(int n, int[] arr1, int[] arr2) {

        List<String> list1 = new ArrayList<>();
        List<String> list2 = new ArrayList<>();
        String[][] arr = new String[n][n];
        String[] answer = new String[n];

        for (int val : arr1) { // 9 , 20, 28, 18 , 11
            StringBuilder sb = new StringBuilder();
            String str = "";
            while(true) {
                if (val == 1) {
                    sb.append(val);
                    break;
                }
                if (val == 0) {
                    sb.append(val);
                    break;
                }
                int num = val % 2; // 1
                sb.append(num);
                val = val / 2;
                if (val == 0) {
                    sb.append("1");
                    break;
                }
            }
            if (sb.toString().length() == n) { // 5 길이가 같다면
                str = sb.reverse().toString(); // 뒤집고
                list1.add(str); // 리스트에 집어넣고
            } else {
                str = sb.toString();
                int length = str.length(); // 4
                for (int i = length; i < n; i++) {
                    str += "0";
                }
                sb.setLength(0);
                sb.append(str);
                list1.add(sb.reverse().toString());
            }
        }

        for (int val : arr2) { //9 , 20, 28, 18 , 11
            StringBuilder sb = new StringBuilder();
            String str = "";
            while(true) {
                if (val == 1) {
                    sb.append(val);
                    break;
                }
                if (val == 0) {
                    sb.append(val);
                    break;
                }
                int num = val % 2; // 1
                sb.append(num);
                val = val / 2;

                if (val == 0) {
                    sb.append("1");
                    break;
                }
            }
            if (sb.toString().length() == n) { // 5 길이가 같다면
                str = sb.reverse().toString(); // 뒤집고
                list2.add(str); // 리스트에 집어넣고
            } else {
                str = sb.toString();
                int length = str.length(); // 4
                for (int i = length; i < n; i++) {
                    str += "0";
                }
                sb.setLength(0);
                sb.append(str);
                list2.add(sb.reverse().toString());
            }
        }

        for (int i = 0; i < n; i++) {
            String str1 = list1.get(i);
            String str2 = list2.get(i);
            String[] str1Arr = str1.split("");
            String[] str2Arr = str2.split("");
            for (int j = 0; j < n; j++) {
                if (Integer.parseInt(str1Arr[j]) == 1 || Integer.parseInt(str2Arr[j]) ==1) {
                    arr[i][j] = "#";
                } else {
                    arr[i][j] = " ";
                }
            }
        }

        for (int i = 0; i < n; i++) {
            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < n; j++) {
                sb.append(arr[i][j]);
            }
            answer[i] = sb.toString();
        }

        return answer;
    }
}