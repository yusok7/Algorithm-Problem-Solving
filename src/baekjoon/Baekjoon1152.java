package baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Baekjoon1152 {
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int result = 0;

		String input = br.readLine();
		String trim = input.trim();

		int length = trim.length();

		char[] arr = new char[length];
		arr = trim.toCharArray();

		for (char c : arr) {
			if (c == ' ') {
				result++;
			}
		}

		bw.write(String.valueOf(result+1));
		bw.flush();
		bw.close();
	}
}
