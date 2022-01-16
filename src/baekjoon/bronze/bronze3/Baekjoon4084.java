package baekjoon.bronze.bronze3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baekjoon4084 {

    public static int[] arr = new int[4];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while (true) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());
            if (a == 0 && b == 0 && c == 0 && d == 0) {
                break;
            }

            arr[0] = a;
            arr[1] = b;
            arr[2] = c;
            arr[3] = d;

            if (arr[0] == arr[1] && arr[1] == arr[2] && arr[2] == arr[3]) {
                System.out.println(0);
                continue;
            }

            int count = 1;
            while (true) {
                int x = arr[0];
                int y = arr[1];
                int z = arr[2];
                int w = arr[3];

                arr[0] = Math.abs(x - y);
                arr[1] = Math.abs(y - z);
                arr[2] = Math.abs(z - w);
                arr[3] = Math.abs(w - x);

                if (arr[0] == arr[1] && arr[1] == arr[2] && arr[2] == arr[3]) {
                    System.out.println(count);
                    break;
                }
                count++;
            }
        }
    }
}
