package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Baekjoon4949 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        List<String> strList = new ArrayList<>();

        while (true) {
            String str = br.readLine();
            // 종료조건
            if (str.equals(".")) {
                break;
            }
            strList.add(str);
        }

        String[] strArr = new String[strList.size()];
        for (int i = 0; i < strList.size(); i++) {
            strArr[i] = strList.get(i);
        }

        while (true) {
            List<String> list = new ArrayList<>();
            int count1 = 0;
            int count2 = 0;

            int result = 0;
            for(String val : strArr) {
                if (val.equals("(")) {
                    list.add("(");
                    count1 ++;
                }
                if (val.equals(")")) {
                    list.add(")");
                    count1 --;
                }
                if (val.equals("[")) {
                    list.add("[");
                    count2++;
                }
                if (val.equals("]")) {
                    list.add("]");
                    count2--;
                }
                if (count1 < 0 || count2 < 0) {
                    break;
                }
                for (int i = 0 ; i < list.size()-1; i++) {
                    if ( (list.get(i).equals("(") && list.get(i+1).equals("]")) || (list.get(i).equals("[") && list.get(i+1).equals(")"))) {
                        result++;
                    }
                }
            }
            if (result == 0 && count1 ==0 && count2 == 0) {
                System.out.println("yes");
            }
            if (count1 < 0 || count2 < 0 || result!=0) {
                System.out.println("no");
            }
        }
    }
}
