package baekjoon.bronze.bronze3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Baekjoon13698 {

    static class Position {
        int a;
        int b;

        public Position(int a, int b) {
            this.a = a;
            this.b = b;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[] ball = new int[4];
        ball[0] = 1;
        ball[3] = 2;

        int index = 0;
        Position[] arr = new Position[6];
        for (int i = 0; i < 3; i++) {
            for (int j = i + 1; j <= 3; j++) {
                Position position = new Position(i, j);
                arr[index++] = position;
            }
        }

        char[] chars = br.readLine().toCharArray();
        int[] charArr = new int[chars.length];
        for (int i = 0; i < charArr.length; i++) {
            charArr[i] = (int)chars[i] - 65;
        }

        for (int val : charArr) {
            Position position = arr[val];
            int c = ball[position.a];
            ball[position.a] = ball[position.b];
            ball[position.b] = c;
        }

        int a = 0;
        int b = 0;
        for (int i = 0; i < 4; i++) {
            if (ball[i] == 1)
                a = i;
            if (ball[i] == 2)
                b = i;
        }
        System.out.println(a + 1);
        System.out.println(b + 1);
    }
}
