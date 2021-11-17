package algorithm.euclid;

public class EuclidGCD {

    public static int gcd(int x, int y) {
        if (y == 0) {
            return x;
        } else {
            return gcd(y, x % y);
        }
    }

    public static void main(String[] args) {
        int x = 22;
        int y = 8;
        System.out.print(x + "와 " + y + "의 최대공약수: ");
        System.out.println(gcd(x, y));
    }
}
