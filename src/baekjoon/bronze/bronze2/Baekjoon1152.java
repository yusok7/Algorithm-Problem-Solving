package baekjoon.bronze.bronze2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Baekjoon1152 {

	public static void main(String[] args) throws IOException {
		List<String> list = new ArrayList<>();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		char[] chars = br.readLine().toCharArray();

		int answer = 0;
		boolean bool = false;
		for (char c : chars) {
			if (Character.isUpperCase(c) || Character.isLowerCase(c)) {
				if (bool == false)
					answer++;
				bool = true;
				continue;
			}
			if (c == ' ' && bool == true)
				bool = false;
		}
		System.out.println(answer);
	}
}
