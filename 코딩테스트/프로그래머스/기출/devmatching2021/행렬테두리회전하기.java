package 프로그래머스.기출.devmatching2021;


import java.util.Arrays;

public class 행렬테두리회전하기 {
    public static void main(String[] args) {
//        int[] results = solution(6, 6, new int[][] {{2,2,5,4},{3,3,6,6},{5,1,6,3}});
//        int[] results2 = solution(100, 97, new int[][] {{1,1,100,97}});
        int[] results3 = solution(3, 3, new int[][] {{1,1,2,2}, {1,2,2,3}, {2,1,3,2}, {2,2,3,3}});
//        System.out.println(Arrays.toString(results));
//        System.out.println(Arrays.toString(results2));
        System.out.println(Arrays.toString(results3));
    }

    public static int[] solution(int rows, int columns, int[][] queries) {
        int[][] table = new int[rows][columns];

        int count = 0;
        for (int i = 0; i < rows; i++)
            for (int j = 0; j < columns; j++) {
                table[i][j] = ++count;
            }


        int[] minValues = new int[queries.length];
        int index = 0;
        for (int[] query: queries) {
            int x1 = query[0] - 1;
            int y1 = query[1] - 1;
            int x2 = query[2] - 1;
            int y2 = query[3] - 1;

            int next = table[x1][y1];
            int current;
            int minValue = rows * columns;
            for (int i = y1 ; i <= y2; i++) {
                current = table[x1][i];
                minValue = Math.min(minValue, current);
                table[x1][i] = next;
                next = current;
            }
            for (int i = x1 + 1; i <= x2; i++) {
                current = table[i][y2];
                minValue = Math.min(minValue, current);
                table[i][y2] = next;
                next = current;
            }
            for (int i = y2 -1; i >= y1; i--) {
                current =  table[x2][i];
                minValue = Math.min(minValue, current);
                table[x2][i] = next;
                next = current;
            }
            for (int i = x2 -1; i >= x1; i--) {
                current = table[i][y1];
                minValue = Math.min(minValue, current);
                table[i][y1] = next;
                next = current;
            }

            minValues[index++] = minValue;
        }

        return minValues;
    }
}
