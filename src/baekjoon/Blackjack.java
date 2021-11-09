package baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Blackjack {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int[] arr = new int[N];

		st = new StringTokenizer(br.readLine(), " ");
		for (int a = 0; a < arr.length; a++) {
			arr[a] = Integer.parseInt(st.nextToken());
		}

		ArrayList<Integer> list = new ArrayList<>();

		int sum = 0;
		int check = 0;
		int result = 0;

		for (int i = 0; i < N - 2; i++) {
			for (int j = i + 1; j < N - 1; j++) {
				for (int k = i + 2; k < N; k++) {
					sum = arr[i] + arr[j] + arr[k];
					list.add(sum);
				}
			}
		}

		HashSet<Integer> distinctData = new HashSet<Integer>(list);
		list = new ArrayList<Integer>(distinctData);

		// 정렬
		Collections.sort(list);

		// 값 접근해 값을 넘는지 확인
		for (int i = 0; i < list.size(); i++) {
			if (list.size() == 1) {
				result = list.get(0);
				break;
			}
			check = list.get(i);
			if (check > M) {
				result = list.get(i - 1);
				break;
			}
		}

		bw.write(String.valueOf(result));
		bw.flush();
		bw.close();
		br.close();
	}
}
