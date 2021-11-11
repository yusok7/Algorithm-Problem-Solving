package programmers.leveltwo;

public class AnticipateMatchList {

    public int solution(int n, int a, int b) {
        int answer = 0;
        int c = 0;
        if (a > b) {
            c = a;
            a = b;
            b = c;
        }
        while (true) {
            answer++;
            if (a % 2 == 1 && b % 2 == 0 && b - a == 1) {
                break;
            }
            if (a % 2 == 0) {
                a = a / 2;
            } else if (a % 2 == 1) {
                a = a / 2 + 1;
            }
            if (b % 2 == 0) {
                b = b / 2;
            } else if (b % 2 == 1) {
                b = b / 2 + 1;
            }
        }
        return answer;
    }
}
