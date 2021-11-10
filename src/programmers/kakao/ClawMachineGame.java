package programmers.kakao;

import java.util.Stack;

public class ClawMachineGame {

    public static void main(String[] args) {
        int[][] board = {{0,0,0,0,0},{0,0,1,0,3},{0,2,5,0,1},{4,2,4,4,2},{3,5,1,3,1}};
        int[] moves = {1,5,3,5,1,2,1,4};
        int solution = solution(board, moves);
        System.out.println(solution);
    }

    public static int solution(int[][] board, int[] moves) {
        Stack<Integer> stack = new Stack<>();
        int answer = 0;
        int boardLength = board.length;

        for (int val : moves) {
            int num = 0;

            for (int i = 0; i < boardLength; i++) {
                if (board[i][val-1] != 0) {
                    num = board[i][val-1];
                    board[i][val-1] = 0;
                    break;
                }
            }

            if (num != 0) {
                if (stack.size() == 0) {
                    stack.add(num);
                } else {
                    Integer peek = stack.peek();
                    if (peek == num) {
                        stack.pop();
                        answer++;
                    } else {
                        stack.add(num);
                    }
                }
            }
        }
        return answer * 2;
    }
}
