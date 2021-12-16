package programmers.levelone;

public class Euclid {

    public int[] solution(int n, int m) {
        int[] answer = new int[2];
        int val1 = func(n, m);
        int val2 = n * m / val1;
        answer[0] = val1;
        answer[1] = val2;
        return answer;
    }

    public int func(int n, int m) {
        int r = n % m;
        if (r == 0) {
            return m;
        } else {
            return func(m, r);
        }
    }
}
