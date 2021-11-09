import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Baekjoon11720 {
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int i = Integer.parseInt(br.readLine());
		String[] strArray = br.readLine().split("");

		int sum = 0;

		for (int a = 0; a < strArray.length; a++) {
			sum += Integer.parseInt(strArray[a]);
		}

		bw.write(String.valueOf(sum));
		bw.flush();
		bw.close();
		br.close();
	}
}
