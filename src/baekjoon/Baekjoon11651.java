package baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Baekjoon11651 {
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int N = Integer.parseInt(br.readLine());

		int[][] arr = new int[N][2];

		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			arr[i][0] = Integer.parseInt(st.nextToken());
			arr[i][1] = Integer.parseInt(st.nextToken());
		}

		Arrays.sort(arr, (int[] a1, int[] a2) -> {
			if (a1[1] == a2[1]) {
				return a1[0] - a2[0];
			} else {
				return a1[1] - a2[1];
			}
		});

		for (int j = 0 ; j<N; j++) {
			bw.write(String.valueOf(arr[j][0])+" ");
			bw.write(String.valueOf(arr[j][1])+"\n");
			bw.flush();
		}

		bw.close();
		br.close();
	}
}
