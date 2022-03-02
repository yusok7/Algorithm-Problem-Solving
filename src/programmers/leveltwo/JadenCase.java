package programmers.leveltwo;

public class JadenCase {

    public static void main(String[] args) {
        String s = " rhir     AAAAAAAAAAAA  f  e f fe  fe  f e  e  w w    2  2 22222e  re re r e re re re f ef  2 22  2 2 2";
        String solution = solution(s);
        System.out.println(solution);
    }

    public static String solution(String s) {
        s = s.toLowerCase();
        StringBuilder sb = new StringBuilder();
        String answer = "";

        boolean bool = true;
        for (char c : s.toCharArray()) {
            if (c == ' ') {
                bool = true;
                sb.append(c);
                continue;
            } else if (Character.isLowerCase(c) && bool == true) {
                String str = String.valueOf(c);
                str = str.toUpperCase();
                sb.append(str);
                bool = false;
                continue;
            } else if (Character.isDigit(c)) {
                sb.append(c);
                bool = false;
            } else {
                String str = String.valueOf(c);
                str = str.toLowerCase();
                sb.append(str);
                continue;
            }
        }
        answer = sb.toString();
        return answer;
    }
}
