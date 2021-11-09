package baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class Baekjoon2750 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		String str = "123";
		int length = str.length();

		int N = Integer.parseInt(br.readLine());
		ArrayList<Integer> list = new ArrayList<>();

		for (int i = 0; i < N; i++) {
			int i1 = Integer.parseInt(br.readLine());

			if (list.contains(i1)) {
				continue;
			}

			list.add(i1);
		}

		Collections.sort(list);

		for (int j=0; j<list.size();j++) {
			System.out.println(list.get(j));
		}
	}
}
