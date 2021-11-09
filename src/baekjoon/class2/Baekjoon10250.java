package baekjoon.class2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baekjoon10250 {
    public static int[][] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int h = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            arr = new int[h][w];

            for (int a = 0; a < w; a++) {
                for (int b = 0; b < h; b++) {
                    if (a < 9) {
                        String str = String.valueOf(b+1) + String.valueOf("0"+(a+1));
                        arr[b][a] = Integer.parseInt(str);
                    } else {
                        String str = String.valueOf(b+1) + String.valueOf(a+1);
                        arr[b][a] = Integer.parseInt(str);
                    }
                }
            }

//            for (int a = 0; a < w; a++) {
//                for (int b = 0; b < h; b++) {
//                    System.out.println(arr[b][a]);
//                }
//            }

            int number = Integer.parseInt(st.nextToken());
            boolean bool = false;
            int count = 1;
            for (int a = 0; a < w; a++) {
                for (int b = 0; b < h; b++) {
                   if (count == number) {
                       System.out.println(arr[b][a]);
                       bool = true;
                       break;
                   } else {
                       count++;
                   }
                }
                if (bool) break;
            }

        }
    }
}
