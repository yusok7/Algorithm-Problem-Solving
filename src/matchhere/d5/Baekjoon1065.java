package matchhere.d5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Baekjoon1065 {

    public static boolean[] bool;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        bool = new boolean[n + 1];

        int answer = 0;
        for (int i = 1; i <= n; i++) {
            func(i);
        }
        for (int i = 0; i <= n; i++) {
            if (bool[i]) {
                answer++;
            }
        }
        System.out.println(answer);
    }

    public static void func(int n) {
        if (n < 10) {
            bool[n] = true;
        } else {
            String[] strArr = String.valueOf(n).split("");
            int m = Integer.parseInt(strArr[0]) - Integer.parseInt(strArr[1]);
            boolean bool2 = false;
            for (int i = 0; i < strArr.length -1; i++) {
                int a = Integer.parseInt(strArr[i]);
                int b = Integer.parseInt(strArr[i + 1]);
                if (a - b != m) {
                    bool2 = true;
                    break;
                }
            }
            if (bool2) return;
            else {
                bool[n] = true;
            }
        }
    }
}
