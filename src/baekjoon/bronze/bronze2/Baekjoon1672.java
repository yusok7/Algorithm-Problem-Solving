package baekjoon.bronze.bronze2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Baekjoon1672 {

    private static char[] charA = {'A', 'G', 'C', 'T'};
    private static char[][] a = {
            {'A', 'C', 'A', 'G'},
            {'C', 'G', 'T', 'A'},
            {'A', 'T', 'C', 'G'},
            {'G', 'A', 'G', 'T'}
    };
    private static char[][] arr;

    public static void main(String[] args) throws IOException {
        arr = new char[26][26];
        func();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        String input = br.readLine();
        char[] charArr = new char[n];
        for (int i = 0; i < n; i++)
            charArr[i] = input.charAt(i);

        if (n == 1) {
            System.out.println(charArr[0]);
            System.exit(0);
        }

        char answer = ' ';
        int x = (int)charArr[n - 2] - 65;
        int y = (int)charArr[n - 1] - 65;
        charArr[n - 2] = charArr[n - 1] = 'O';
        answer = arr[x][y];

        int index = n - 3;
        while (true) {
            if (charArr[0] == 'O')
                break;
            x = (int)charArr[index] - 65;
            y = (int)answer - 65;
            answer = arr[x][y];
            charArr[index--] = 'O';
        }
        System.out.println(answer);
    }

    private static void func() {
        for (int i = 0; i < charA.length; i++) {
            for (int j = 0; j < charA.length; j++) {
                int x = (int)charA[i] - 65;
                int y = (int)charA[j] - 65;
                arr[x][y] = a[i][j];
            }
        }
    }
}
