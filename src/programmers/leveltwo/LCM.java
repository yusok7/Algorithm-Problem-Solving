package programmers.leveltwo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LCM {

    public static List<Integer> list = new ArrayList<>();

    public static void main(String[] args) {
        int[] arr = {2, 6, 8, 14};
        int solution = solution(arr);
        System.out.println(solution);
    }

    public static int solution(int[] arr) {
        int answer = 0;
        for (int val : arr) {
            list.add(val);
        }
        Collections.sort(list, Collections.reverseOrder());
        for (int i = 0; i < list.size(); i++) {
            arr[i] = list.get(i);
        }
        list.clear();
        for (int i = 0; i < arr.length - 1; i++) { // 0 1 2
            for (int j = i + 1; j < arr.length; j++) { // 1 2 3
                int gcd = func(arr[i], arr[j]);
                list.add(arr[i] * arr[j] / gcd);
            }
        }
        int count = 2;
        while (true) {
            for (Integer val : list) {
                boolean bool = true;
                for (int val2 : arr) {
                    if (val % val2 != 0) {
                        bool = false;
                    }
                }
                if (bool) {
                    answer = val;
                    break;
                }
            }
            if (answer == 0) {
                for (int i = 0; i < list.size(); i++) {
                    if (count == 2) {
                        list.set(i, list.get(i) * count);
                    } else {
                        list.set(i, list.get(i) / (count - 1) * count);
                    }
                }
                count++;
            } else {
                break;
            }
        }
        return answer;
    }

    public static int func(int n, int m) {
        int r = n % m;
        if (r == 0) {
            return m;
        } else {
            return func(m, r);
        }
    }
}
