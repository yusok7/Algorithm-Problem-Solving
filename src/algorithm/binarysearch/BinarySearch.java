package algorithm.binarysearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BinarySearch {

    public static void main(String[] args) throws IOException {
        StringBuilder sb = new StringBuilder();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[] arr = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());

        int index = 0;
        while (st.hasMoreTokens())
            arr[index++] = Integer.parseInt(st.nextToken());
        Arrays.sort(arr);

        int m = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < m; i++) {
            int num = Integer.parseInt(st.nextToken());
            int start = 0;
            int end = n - 1;

            while (true) {
                int mid = (start + end) / 2;
                if (arr[mid] == num) {
                    sb.append(1).append("\n");
                    break;
                }

                if (arr[mid] > num)
                    end = mid - 1;
                else if (arr[mid] < num)
                    start = mid + 1;

                if (start > end) {
                    sb.append(0).append("\n");
                    break;
                }
            }
        }
        System.out.println(sb.toString());
    }
}
