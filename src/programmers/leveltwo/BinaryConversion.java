package programmers.leveltwo;

public class BinaryConversion {

    public int[] solution(String s) {
        int[] answer = new int[2];
        int count = 0;
        int sum = 0;
        while(true) {
            count++;
            int firstLength = s.length();
            s = s.replaceAll("0", "");
            int secondLength = s.length();
            sum += firstLength - secondLength;
            s = Integer.toBinaryString(secondLength);
            if (s.equals("1")) break;
        }
        answer[0] = count;
        answer[1] = sum;
        return answer;
    }
}
