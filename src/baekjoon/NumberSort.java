package baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class NumberSort {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int N = Integer.parseInt(br.readLine());
		int[] arr = new int[N];

		for (int i = 0; i < N; i++) {
			int input = Integer.parseInt(br.readLine());
			arr[i] = input;
		}

		Arrays.sort(arr);

		for (int j = 0; j < N; j++) {
			bw.write(String.valueOf(arr[j])+"\r\n");
			bw.flush();
		}
		bw.close();
		br.close();
	}
}
