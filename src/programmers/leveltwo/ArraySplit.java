package programmers.leveltwo;

public class ArraySplit {

    public int[] solution(int n, long left, long right) {
        int[][] arr = new int[n][n];
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                if (j <= i) {
                    arr[i][j] = i+1;
                } else {
                    arr[i][j] = j+1;
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                sb.append(String.valueOf(arr[i][j]));
            }
        }
        String str = sb.toString();
        str = str.substring((int)left,(int)right+1);
        String[] strArr = str.split("");
        int[] answer = new int[strArr.length];
        for (int i = 0; i < answer.length; i++) {
            answer[i] = Integer.parseInt(strArr[i]);
        }
        return answer;
    }
}
