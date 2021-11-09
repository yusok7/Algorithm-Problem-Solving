package programmers.leveltwo;

/**
 * https://programmers.co.kr/learn/courses/30/lessons/12945
 */

public class Fibonachi {

    public static long[] d = new long[100000];

    public static void main(String[] args) {
        int n = 10999;
        System.out.println(solution(n));


    }

    public static long solution(long n) {
        return fibo(n);
    }

    public static long fibo(long x) {
        d[1] = 1;
        d[2] = 1;

        for (int i = 3; i <=x; i++) {
            d[i] = d[i-1] + d[i-2];
        }
        return d[(int) x];
    }
}
