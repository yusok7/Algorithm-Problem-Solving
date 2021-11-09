package baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Baekjoon9012 {
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int N = Integer.parseInt(br.readLine());
		String[] result = new String[N];

		for (int i = 0; i < N; i++) {
			String input = br.readLine();
			String[] split = input.split("");
			int count = 0;

			for (int j = 0; j < split.length; j++) {
				if (split[0].equals(")")) {
					result[i] = "NO";
					break;
				}

				if (split[j].equals("(")) {
					count +=1;
				} else {
					count -=1;
				}

				if (count < 0) {
					result[i] = "NO";
					break;
				}
				if (j == split.length-1) {
					if (count == 0 ) {
						result[i] = "YES";
					}else {
						result[i] = "NO";
					}
				}
			}
		}
		for (int a = 0; a< result.length;a++){
			System.out.println(result[a]);
		}
	}
}
