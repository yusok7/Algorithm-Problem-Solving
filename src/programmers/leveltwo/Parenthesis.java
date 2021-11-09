package programmers.leveltwo;

/**
 * https://programmers.co.kr/learn/courses/30/lessons/12909#
 */
public class Parenthesis {
    public static void main(String[] args) {
        String s = ")()(";
        solution(s);
    }

    public static boolean solution(String s) {
        String[] strArr = new String[s.length()];
        for (int i = 0 ; i < s.length(); i++) {
            strArr[i] = String.valueOf(s.charAt(i));
        }
        boolean answer = true;
        int count = 0;
        for (String val : strArr) {
            if (val.equals("(")) {
                count ++;
            } else {
                count --;
            }
            if (count < 0) {
                answer = false;
                break;
            }
        }
        if(count!=0) {
            answer = false;
        }

        return true;
    }
}
