package programmers.levelone;

public class Year2016 {

    public String solution(int a, int b) {
        int[] arr = {0, 31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        String[] day = {"FRI","SAT","SUN","MON","TUE","WED","THU"};

        String answer = "";

        int sum = b;
        for (int i = 1; i < a; i++) {
            sum += arr[i];
        }

        int result = sum % 7 - 1;
        if (result < 0) result = 6;
        answer = day[result];
        return answer;
    }
}
