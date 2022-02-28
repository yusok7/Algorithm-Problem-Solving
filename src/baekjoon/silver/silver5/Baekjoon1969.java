package baekjoon.silver.silver5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Baekjoon1969 {

    private static String[][] strArr;
    private static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        strArr = new String[n][m];

        for (int i = 0; i < n; i++) {
            String str = br.readLine();
            for (int j = 0; j < m; j++) {
                strArr[i][j] = String.valueOf(str.charAt(j));
            }
        }

        for (int j = 0; j < m; j++) {
            int[] arr = new int[26];
            for (int i = 0; i < n; i++) {
                char c = strArr[i][j].charAt(0); // 'T'
                int index = c - 'A';
                arr[index]++;
            }
            int maxValue = Arrays.stream(arr)
                    .max()
                    .getAsInt();
            int index = getIndex(arr, maxValue);
            char ch = (char) (index + 65);
            sb.append(ch);
        }
        String str = sb.toString();
        int sum = 0;
        for (int i = 0; i < n; i++) {
            StringBuilder sb2 = new StringBuilder();
            for (int j = 0; j < m; j++) {
                sb2.append(strArr[i][j]);
            }
            sum += getResult(str, sb2.toString());
        }
        System.out.println(str);
        System.out.println(sum);
    }

    private static int getIndex(int[] arr, int maxValue) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == maxValue)
                return i;
        }
        return 0;
    }

    private static int getResult(String str1, String str2) {
        char[] char1 = str1.toCharArray();
        char[] char2 = str2.toCharArray();
        int answer = 0;
        for (int i = 0; i < char1.length; i++) {
            if (char1[i] != char2[i])
                answer++;
        }
        return answer;
    }
}
