package baekjoon.silver.silver5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baekjoon9037 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        for (int i = 0; i < n; i++) {
            int num = Integer.parseInt(br.readLine());
            int[] arr = new int[num];
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < num; j++) {
                arr[j] = Integer.parseInt(st.nextToken());
            }

            int count = 0;
            while (true) {
                add(arr);
                if (check(arr)) {
                    System.out.println(count);
                    break;
                }
                func(arr);
                count++;
            }
        }
    }

    // 홀수개 사탕 채워주는 메서드
    private static void add(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] % 2 == 1)
                arr[i] += 1;
        }
    }

    // 사탕이 모두 같은지 확인하는 메서드
    private static boolean check(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            if (arr[i] != arr[i + 1])
                return false;
        }
        return true;
    }

    // 반으로 나누어 옆 친구한테 주기
    private static void func(int[] arr) {
        int[] arr2 = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            if (i == arr.length - 1) {
                int num = arr[i] / 2;
                arr[i] = arr[i] - num;
                arr2[0] = num;
            } else {
                int num = arr[i] / 2;
                arr[i] = arr[i] - num;
                arr2[i + 1] = num;
            }
        }
        for (int i = 0; i < arr2.length; i++) {
            arr[i] += arr2[i];
        }
    }
}
