package matchhere.d5;

public class Baekjoon4673 {

    public static boolean bool[] = new boolean[10001];

    public static void main(String[] args) {
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= 10000; i++) {
            func(i);
        }
        for (int i = 1; i <= 10000; i++) {
            if (!bool[i]) {
                sb.append(i).append("\n");
            }
        }
        System.out.println(sb.toString());
    }

    public static void func(int n) {
        if (n < 10) {
            n = n + n;
            bool[n] = true;
        } else {
            String[] strArr = String.valueOf(n).split("");
            int sum = 0;
            for (String val : strArr) {
                sum += Integer.parseInt(val);
            }
            n = n + sum;
            if (n > 10000) {
                return;
            }
            bool[n] = true;
        }
    }
}
