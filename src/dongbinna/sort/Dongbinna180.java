package dongbinna.sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Dongbinna180 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        String[][] strArr = new String[n][2];

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            strArr[i][0] = st.nextToken();
            strArr[i][1] = st.nextToken();
        }

        Arrays.sort(strArr, (String[] a1, String[] a2) -> {
            return Integer.parseInt(a1[1]) - Integer.parseInt(a2[1]);
        });

        StringBuilder sb = new StringBuilder();
        for (String[] val : strArr) {
            sb.append(val[0]).append(" ");
        }

        System.out.println(sb.toString());
    }
}
