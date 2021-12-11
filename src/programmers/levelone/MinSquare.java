package programmers.levelone;

public class MinSquare {

    public List<Integer> list1 = new ArrayList<>();
    public List<Integer> list2 = new ArrayList<>();
    public int solution(int[][] sizes) {
        int answer = 0;
        for (int[] val : sizes) {
            int max = Math.max(val[0], val[1]);
            int min = Math.min(val[0], val[1]);
            list1.add(max);
            list2.add(min);
        }
        answer = Collections.max(list1) * Collections.max(list2);
        return answer;
    }
}
