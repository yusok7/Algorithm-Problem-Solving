package baekjoon.bronze.bronze3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Baekjoon9517 {

    private static int[] arr = new int[9];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int k = Integer.parseInt(br.readLine());
        int n = Integer.parseInt(br.readLine());

        int sum = 0;
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int num = Integer.parseInt(st.nextToken());
            String str = st.nextToken();
            sum += num;

            if (str.equals("T"))
                arr[k++] = sum;
            else
                arr[k] = sum;
            k = k == 9 ? 1 : k;
        }

        int[] ints = Arrays.stream(arr)
                .filter(i -> i >= 210)
                .toArray();
        int asInt = Arrays.stream(ints)
                .min()
                .getAsInt();
        for (int i = 0; i < arr.length; i++)
            if (arr[i] == asInt)
                System.out.println(i);
    }
}
