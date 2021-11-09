package baekjoon.class2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baekjoon1018 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        String[][] arr = new String[n][m];

        for (int i = 0; i < n; i++) {
            String[] str = br.readLine().split("");
            for (int j = 0; j < m; j++) {
                String string = str[j];
                arr[i][j] = string;
            }
        }

        for (int i = 0; i < n; i++) {
            int count = 0;
            if (i + 8 > n) break;
            for (int j = 0; j < m-1; j++) {
                if (j + 8 > m) break;
                if (!arr[i][j].equals(arr[i][j+1])) {
                    count++;
                    if (arr[i][j+1].equals("W")){
                        arr[i][j+1] = "B";
                    } else {
                        arr[i][j+1] = "W";
                    }
                }
            }
        }
    }
}
