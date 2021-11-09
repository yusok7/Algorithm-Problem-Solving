package baekjoon;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;

public class Baekjoon2557 {
	public static void main(String[] args) throws IOException {

		StringBuilder sb = new StringBuilder();
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		sb.append("Hello ");
		sb.append("World");

		bw.write(sb.toString());
		bw.flush();
		bw.close();
	}
}
