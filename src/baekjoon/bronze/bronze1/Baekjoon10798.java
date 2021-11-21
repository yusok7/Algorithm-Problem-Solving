package baekjoon.bronze.bronze1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Baekjoon10798 {

    public static ArrayList<ArrayList<String>> list = new ArrayList<>();
    public static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int max = 0;

        for (int i = 0; i < 5; i++) {
            list.add(new ArrayList<>());
        }

        for (int i = 0; i < 5; i++) {
            String str = br.readLine();
            max = Math.max(max, str.length());
            String[] strArr = str.split("");
            for (int j = 0; j < strArr.length; j++) {
                list.get(i).add(strArr[j]);
            }
        }

        for (int i = 0; i < 5; i++) {
            for (int j = list.get(i).size(); j < max; j++) {
                list.get(i).add("-");
            }
        }

        for (int i = 0; i < list.get(0).size(); i++) {
            for (int j = 0; j < 5; j++) {
                if (!list.get(j).get(i).equals("-")) {
                    sb.append(list.get(j).get(i));
                }
            }
        }

        System.out.println(sb.toString());
    }
}
