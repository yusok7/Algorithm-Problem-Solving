package baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Baekjoon2588 {
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int N = Integer.parseInt(br.readLine());
		String M = br.readLine();

		String[] split = M.split("");

		bw.write(String.valueOf(N*Integer.parseInt(split[2]))+"\r\n");
		bw.write(String.valueOf(N*Integer.parseInt(split[1]))+"\r\n");
		bw.write(String.valueOf(N*Integer.parseInt(split[0]))+"\r\n");
		bw.write(String.valueOf(N*Integer.parseInt(M)));

		bw.flush();
		bw.close();
		br.close();
	}
}
