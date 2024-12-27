package 프로그래머스.고득점kit.완전탐색;

public class 최소직사각형 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.solution(new int[][] {{60, 50}, {30, 70}, {60, 30}, {80, 40}}));
        System.out.println(solution.solution(new int[][] {{10, 7}, {12, 3}, {8, 15}, {14, 7}, {5, 15}}));
        System.out.println(solution.solution(new int[][] {{14, 4}, {19, 6}, {6, 16}, {18, 7}, {7, 11}}));
    }
}

class Solution {
    public int solution(int[][] sizes) {
        int x = 0, y = 0;

        for (int[] size: sizes) {
            if (size[0] > size[1]) {
                x = Math.max(size[0], x);
                y = Math.max(size[1], y);
            } else {
                x = Math.max(size[1], x);
                y = Math.max(size[0], y);
            }
        }
        return x * y;
    }
}