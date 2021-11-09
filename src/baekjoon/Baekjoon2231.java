package baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Baekjoon2231 {
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		// 입력
		int N = Integer.parseInt(br.readLine());

		int count = 0;
		int result = 0;
		String number = "";

		while (true) {
			number = String.valueOf(count);
			String[] split = number.split("");
			result += count;
			for (int i = 0; i < split.length; i++) {
				result += Integer.parseInt(split[i]);
			}
			if (result == N) {
				break;
			}
			if (count >= N) {
				count = 0;
				break;
			}
			result = 0;
			count++;
		}
		bw.write(String.valueOf(count));
		bw.flush();
		bw.close();
		br.close();
	}
}
