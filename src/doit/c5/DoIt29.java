package doit.c5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class DoIt29 {

    private static int n, m;
    private static int[] arr;
    private static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        arr = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++)
            arr[i] = Integer.parseInt(st.nextToken());
        Arrays.sort(arr);

        m = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        while (st.hasMoreTokens()) {
            int num = Integer.parseInt(st.nextToken());
            if (binarySearch(num))
                sb.append(1).append("\n");
            else
                sb.append(0).append("\n");
        }
        System.out.println(sb.toString());
    }

    private static boolean binarySearch(int num) {
        int start = 0;
        int end = arr.length - 1;

        while (true) {
            int mid = (start + end) / 2;
            if (arr[mid] == num)
                return true;
            if (arr[mid] > num)
                end = mid - 1;
            else
                start = mid + 1;

            if (start > end)
                return false;
        }
    }
}
