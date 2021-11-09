package dongbinna.dynamicprogramming;

public class InefficiencyFibonachi {

    public static void main(String[] args) {
        System.out.println(fibo(100));
    }

    public static int fibo(int x) {
        if (x == 1 || x == 2) {
            return 1;
        }
        System.out.println(1);
        return fibo(x-1) + fibo(x-2);
    }
}
