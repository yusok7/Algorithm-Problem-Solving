package baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class PairTest {

	static class Meet {
		int day;
		int t;
		int p;

		public Meet(int day, int t, int p) {
			this.day = day;
			this.t = t;
			this.p = p;
		}

		// 남아있는 값들중에

		@Override
		public String toString() {
			return "Meet{" +
				"day=" + day +
				", t=" + t +
				", p=" + p +
				'}';
		}
	}

	public static void main(String[] args) throws IOException {

		// BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		//
		// int n = Integer.parseInt(br.readLine());
		// List<Meet> list = new ArrayList<>();
		//
		// for (int i =0; i<n ;i++) {
		// 	StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		// 	list.add(new Meet(i+1,Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken())));
		// }


		int n = 10;
		List<Meet> list = new ArrayList<>();

		list.add(new Meet(1,5,50));
		list.add(new Meet(2,4,40));
		list.add(new Meet(3,3,30));
		list.add(new Meet(4,2,20));
		list.add(new Meet(5,1,10));

		list.add(new Meet(6,3,10));
		list.add(new Meet(7,2,20));

		list.add(new Meet(8,3,30));
		list.add(new Meet(9,4,40));
		list.add(new Meet(10,5,50));


		List<Meet> possibleList = new ArrayList<>();
		for (int index = 0; index < n; index++) {
			if (list.get(index).t + list.get(index).day <= n) {
				possibleList.add(list.get(index));
			}
		}

		int result = 0;
		int sum = 0;


		ArrayList<Integer> result2 = new ArrayList<>();
		int lastDay = possibleList.size();

		for (int index = 0; index < possibleList.size() ; index++) {
			int count = index;
			while (true) {
				sum += list.get(count).p;
				count = list.get(count).day + list.get(count).t -1;
				if (count > possibleList.get(lastDay-1).day) {
					result2.add(sum);
					break;
				}
			}
			sum = 0;
		}
		System.out.println(result2);
		System.out.println("Collections.max(result2) = " + Collections.max(result2));

	}
}