package samsung;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Baekjoon14889 {

    public static int[] arr1;
    public static int[] arr2;
    public static List<int[]> list1 = new ArrayList<>();
    public static List<int[]> list2 = new ArrayList<>();
    public static boolean[] visit;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // 총 인원수
        int n = Integer.parseInt(br.readLine());

        // 2개의 팀을 배열로
        arr1 = new int[n/2];
        arr2 = new int[n/2];
        visit = new boolean[n];

        int[][] input = new int[n][n];

        for(int i = 0; i < n ; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            for(int j = 0; j < n; j++) {
                int num = Integer.parseInt(st.nextToken());
                input[i][j] = num;
            }
        }

        // 팀 나누기
        dfs(n,n/2,0);

        List<Integer> result1 = new ArrayList<>();
        List<Integer> result2 = new ArrayList<>();
        List<Integer> result3 = new ArrayList<>();


        for(int[] arr : list1) {
            int sum = 0;
            for(int i = 0; i < n/2 - 1 ; i++) {
                for(int j = 1; j < n/2; j++) {
                    sum += input[arr[i]][arr[j]];
                    sum += input[arr[j]][arr[i]];
                }
            }
            result1.add(sum);
        }

        for(int[] arr : list2) {
            int sum = 0;
            for(int i = 0; i < n/2 - 1 ; i++) {
                for(int j = 1; j < n/2; j++) {
                    sum += input[arr[i]][arr[j]];
                    sum += input[arr[j]][arr[i]];
                }
            }
            result2.add(sum);
        }

        for(int i = 0; i<result1.size(); i++) {
            int val = Math.abs(result1.get(i)-result2.get(i));
            result3.add(val);
        }

        System.out.println(Collections.min(result3));


    }

    public static void dfs(int n, int m, int depth) {
        // 종료조건
        if (depth == m) {
            int count = 0;
            list1.add(arr1);
            System.out.println(arr1.length);
            System.out.println(arr1[0]);
            System.out.println(arr1[1]);
            for(int i = 0; i<n+1; i++) {
                // arr1에 해당값을 포함하지 않았다면
                System.out.println(Arrays.asList(arr1).contains(1));
                if(Arrays.asList(arr1).contains(i+1)) {
                    arr2[count] = i+1;
                    count++;
                }
            }
            list2.add(arr2);
        }

        for (int i = 0; i < n; i++) {
            if (visit[i] == false) {
                visit[i] = true;
                arr1[depth] = i+1;
                dfs(n,m,depth+1);
                visit[i] = false;
            }
        }
    }

}
