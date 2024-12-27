package 프로그래머스.고득점kit.완전탐색;

public class 카펫TODO {
    public static void main(String[] args) {
        Solution4 solution = new Solution4();
        int[] result = solution.solution(10, 2);
        System.out.printf("[%d, %d]\n", result[0], result[1]); // [4, 3]
        int[] result2 = solution.solution(8, 1);
        System.out.printf("[%d, %d]\n", result2[0], result2[1]);    // [3, 3]
        int[] result3 = solution.solution(24, 24);
        System.out.printf("[%d, %d]\n", result3[0], result3[1]);  // [8, 6]
    }
}

class Solution4 {
    // 8 <= brown <= 5_000, 1 <= yellow <= 2_000_000
    public int[] solution(int brown, int yellow) {
        int totalCount = brown + yellow;

        int[] result = new int[2];
        for (int i = 3; i < totalCount; i++) {
            if (totalCount % i != 0) continue;

            int width = totalCount / i;
            int height = i;

            if (yellow == (width - 2) * (height -2) && brown == (totalCount - yellow)) {
                result[0] = width;
                result[1] = height;
                break;
            }

            if(width < height) {
                break;
            }
        }

        return result;
    }
}