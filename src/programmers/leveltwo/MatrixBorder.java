package programmers.leveltwo;

import java.util.Arrays;

public class MatrixBorder {

    private static int[][] arr;

    public static void main(String[] args) {
        int[][] queries = {{1,1,100,97}};
        int[] solution = solution(100, 97, queries);
        for (int i : solution) {
            System.out.println("i = " + i);
        }
    }

    public static int[] solution(int rows, int columns, int[][] queries) {

        int[] answer = new int[queries.length];

        // 초기화
        int count = 1;
        arr = new int[rows][columns];
        for (int i = 0; i < rows; i++)
            for (int j = 0; j < columns; j++)
                arr[i][j] = count++;

        count = 0;
        for (int[] query : queries) {
            StringBuilder sb = new StringBuilder();
            int row1 = query[0] - 1;
            int col1 = query[1] - 1;
            int row2 = query[2] - 1;
            int col2 = query[3] - 1;

            for (int i = col1; i <= col2; i++) {
                sb.append(arr[row1][i]).append(" ");
            }
            for (int i = row1 + 1; i <= row2; i++) {
                sb.append(arr[i][col2]).append(" ");
            }
            for (int i = col2 - 1; i >= col1; i--) {
                sb.append(arr[row2][i]).append(" ");
            }
            for (int i = row2 - 1; i > row1; i--) {
                sb.append(arr[i][col1]).append(" ");
            }

            int index = 0;
            String[] strArr = sb.toString().split(" ");
            int min = Arrays.stream(Arrays.stream(strArr)
                            .mapToInt(Integer::parseInt)
                            .toArray())
                    .min()
                    .getAsInt();

            for (int i = col1 + 1; i <= col2; i++)
                arr[row1][i] = Integer.parseInt(strArr[index++]);

            for (int i = row1 + 1; i <= row2; i++)
                arr[i][col2] = Integer.parseInt(strArr[index++]);

            for (int i = col2 - 1; i >= col1; i--)
                arr[row2][i] = Integer.parseInt(strArr[index++]);

            for (int i = row2 - 1; i >= row1; i--)
                arr[i][col1] = Integer.parseInt(strArr[index++]);

            answer[count++] = min;
        }

        return answer;
    }
}
