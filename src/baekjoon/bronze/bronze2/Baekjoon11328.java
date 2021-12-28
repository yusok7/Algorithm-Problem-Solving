package baekjoon.bronze.bronze2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baekjoon11328 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            char[] charArr1 = st.nextToken().toCharArray();
            char[] charArr2 = st.nextToken().toCharArray();
            int[] arr1 = new int[26];
            int[] arr2 = new int[26];

            for (char c : charArr1) {
                int index = (int)c - 97;
                arr1[index]++;
            }
            for (char c : charArr2) {
                int index = (int)c - 97;
                arr2[index]++;
            }

            boolean bool = false;
            for (int j = 0; j < arr1.length; j++) {
                if (arr1[j] != arr2[j]) {
                    bool = true;
                }
            }
            if (bool) System.out.println("Impossible");
            else System.out.println("Possible");
        }
    }
}
