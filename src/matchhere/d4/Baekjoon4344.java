package matchhere.d4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baekjoon4344 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int count = Integer.parseInt(st.nextToken());
            int[] arr = new int[count];
            for (int j = 0; j < count; j++) {
                arr[j] = Integer.parseInt(st.nextToken());
            }

            int sum = 0;
            for (int val : arr) {
                sum += val;
            }
            int average = sum / count;
            int count2 = 0;
            for (int val : arr) {
                if (val > average) {
                    count2++;
                }
            }
            double result = (double)count2 / (double)count * 100;
            System.out.print(String.format("%.3f", result));
            System.out.println("%");
        }
    }
}
