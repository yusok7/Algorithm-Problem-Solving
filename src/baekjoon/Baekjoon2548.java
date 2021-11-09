package baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Baekjoon2548 {
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter((System.out)));

		// 총 입력해야할 수들의 갯수
		int N = Integer.parseInt(br.readLine());
		// 공백을 기준으로 숫자 구분
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		ArrayList<Integer> input = new ArrayList<>();
		for (int i = 0; i < N; i++) {
			// ArrayList에 숫자 담아주기
			input.add(Integer.parseInt(st.nextToken()));
		}

		// 차이들의 합을 담은 ArrayList result
		ArrayList<Integer> result = new ArrayList<>();
		int max = Collections.max(input);
		int sum = 0;

		// 문제에서 주어진 수들의 최대값은 10000
		// 따라서 이 안에서 값이 나올줄 알았는데 아니네..
		for (int i = 0; i < 20000; i++) {
			for (int j = 0; j < N; j++) {
				// 숫자를 1씩 증가시키며 주어진 수들 빼주기
				int subtraction = i - input.get(j);
				if (subtraction < 0) {
					subtraction = subtraction * -1;
				}
				// 차이들의 합
				sum += subtraction;
			}
			// list에 합 담기
			result.add(sum);
			// [숫자0으로 했을 때 주어진 숫자들의 차이의 합, 숫자1로 했을 때 주어진 숫자들의 차이의 합 .......]
			sum = 0;
		}

		// result list내 최소값 뽑아오기
		int min = Collections.min(result);
		int index = result.indexOf(min);

		bw.write(String.valueOf(index));
		bw.flush();
		bw.close();
		br.close();
	}
}
