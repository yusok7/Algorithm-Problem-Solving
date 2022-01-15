package baekjoon.silver.silver4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baekjoon1244 {

    public static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        arr = new int[n + 1];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int testCase = Integer.parseInt(br.readLine());

        for (int i = 0; i < testCase; i++) {
            st = new StringTokenizer(br.readLine());
            int gender = Integer.parseInt(st.nextToken());
            int num = Integer.parseInt(st.nextToken());

            while (true) {
                // 남자라면
                if (gender == 1) {
                    int count = 1;
                    while (true) {
                        int index = num * count;
                        if (index > n) break;
                        if (arr[index] == 1) {
                            arr[index] = 0;
                        } else {
                            arr[index] = 1;
                        }
                        count++;
                    }
                } else if (gender == 2) {
                    int count = 1;
                    while (true) {
                        int start = num - count;
                        int end = num + count;
                        // 범위를 넘어갔다는 것은 아직 한번도 바뀌지 않은 것
                        if (start < 1 || end > n) {
                            func(start, end);
                            break;
                        }
                        // 값이 다르다면 ?
                        if (arr[start] != arr[end]) {
                            func(start, end);
                            break;
                        }
                        count++;
                    }
                }
                break;
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= n; i++) {
            if (i % 20 == 1 && i != 1) {
                sb.append("\n");
            }
            sb.append(arr[i]).append(" ");
        }
        System.out.println(sb.toString());
    }

    private static void func(int start, int end) {
        for (int j = start + 1; j <= end - 1; j++) {
            if (arr[j] == 1) arr[j] = 0;
            else arr[j] = 1;
        }
        return;
    }
}
