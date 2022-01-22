package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

/**
 * 해당 문제는 자바의 Arrays.binarySearch(~, ~) 를 통해서도 풀 수 있다.
 * 백준에 binarySearch를 사용해 정답을 확인한 결과
 * 1. 해시를 사용한 검색과
 * 2.이분탐색을 사용한 검색
 * 간에 큰 차이는 없었고
 *
 * 근소한 차이로 해시를 사용한 검색이 시간이 적게 들었다
 */

public class Baekjoon1920 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Map<Integer, Integer> map = new HashMap<>();
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        for (int i = 0; i < n; i++) {
            map.put(Integer.parseInt(st.nextToken()), i);
        }

        int m = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < m; i++) {
            if (map.containsKey(Integer.parseInt(st.nextToken()))) {
                System.out.println(1);
            } else {
                System.out.println(0);
            }
        }
    }
}
