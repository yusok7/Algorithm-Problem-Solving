package baekjoon.silver.silver5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Baekjoon2822 {

    private static List<int[]> list = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for (int i = 0; i < 8; i++)
            list.add(new int[] {i + 1, Integer.parseInt(br.readLine())});

        Collections.sort(list, (int[] arr1, int[] arr2) ->{
            return -(Integer.compare(arr1[1], arr2[1]));
        });

        int sum = 0;
        Integer[] answer = new Integer[5];

        for (int i = 0; i < 5; i++) {
            int[] arr = list.get(i);
            sum += arr[1];
            answer[i] = arr[0];
        }
        Arrays.sort(answer);

        System.out.println(sum);
        for (int i = 0; i < answer.length; i++) {
            System.out.print(answer[i] + " ");
        }
    }
}
