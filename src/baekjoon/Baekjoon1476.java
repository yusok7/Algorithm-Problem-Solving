package baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Baekjoon1476 {
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int[] arr = new int[3];
		int count = 1;
		int E = 1;
		int S = 1;
		int M = 1;

		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		for (int i = 0; i < 3; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		while (true) {
			if (E == arr[0] && S == arr[1] && M == arr[2]) {
				break;
			} else {
				E++;
				S++;
				M++;
				count++;
				if (E == 16) {
					E = 1;
				}
				if (S == 29) {
					S = 1;
				}
				if (M == 20) {
					M = 1;
				}
			}
		}
		bw.write(String.valueOf(count));
		bw.flush();
		bw.close();
		br.close();
	}
}
