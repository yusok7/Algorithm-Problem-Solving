package programmers.levelone;

public class NumberPY {
	public static void main(String[] args) {
		int count1= 0;
		int count2=0;

		String s = "pPyy";

		String[] split = s.split("");
		for (String s1 : split) {
			if (s1.equals("p")||s1.equals("P")) {
				count1++;
			}
			if(s1.equals("y")||s1.equals("Y")) {
				count2++;
			}
		}
	}
}
