package baekjoon.silver.silver4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Baekjoon2840 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        Map<String, Integer> map = new HashMap<>();

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        String[] arr = new String[n];
        for (int i = 0; i < n; i++) {
            arr[i] = "0";
        }

        int lastIndex = 0;
        for (int i = 0; i < k; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            String num = st.nextToken();

            int index = lastIndex;
            for (int j = 0; j < s; j++) {
                index++;
                if (index == n) {
                    index = 0;
                }
                if (j == s - 1) {
                    if ((!arr[index].equals("0")) && !(arr[index].equals(num))) {
                        System.out.println("!");
                        System.exit(0);
                    } else if (arr[index].equals("0") || arr[index].equals(num)) {
                        arr[index] = num;
                        lastIndex = index;
                    }
                }
            }
        }

        for (String val : arr) {
            if (val.equals("0")) continue;
            if (map.containsKey(val)) {
                System.out.println("!");
                System.exit(0);
            } else {
                map.put(val, 0);
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            if (arr[lastIndex].equals("0")) {
                sb.append("?");
            } else {
                sb.append(arr[lastIndex]);
            }
            lastIndex--;
            if (lastIndex < 0) {
                lastIndex = n - 1;
            }
        }

        System.out.println(sb.toString());
    }
}
