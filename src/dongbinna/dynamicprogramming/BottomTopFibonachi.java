package dongbinna.dynamicprogramming;

public class BottomTopFibonachi {

    public static long[] d = new long[9999999];

    public static void main(String[] args) {
        d[1] = 1;
        d[2] = 1;

        int n = 9999998;

        for (int i = 3; i <= n; i++) {
            d[i] = d[i-1] + d[i-2];
        }
        System.out.println(d[n]);
    }
}
