package programmers.leveltwo;

public class NumberExpression {
    public static void main(String[] args) {
        int n = 15;
        int solution = solution(n);
        System.out.println(solution);
    }

    public static int solution(int n) {
        int answer = 0;
        int sum = 0;
        for (int i = 1; i <=n; i++) {
            sum += i;
            for (int j = i+1; j <=n; j++) {
                sum += j;
                if (sum == n) {
                    answer ++;
                    break;
                }
                if (sum > n) {
                    break;
                }
            }
            sum = 0;
        }
        return answer;
    }
}
