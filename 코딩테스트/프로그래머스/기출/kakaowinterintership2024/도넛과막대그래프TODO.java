package 프로그래머스.기출.kakaowinterintership2024;

import java.util.Arrays;

// https://school.programmers.co.kr/learn/courses/30/lessons/258711
// https://given-dev.tistory.com/104
public class 도넛과막대그래프TODO {
    public static void main(String[] args) {
        Solution2 solution2 = new Solution2();
        int[] result = solution2.solution(new int[][] {{2, 3}, {4, 3}, {1, 1}, {2, 1}});
        Arrays.stream(result).forEach(System.out::println);

        int[] result2 = solution2.solution(new int[][] {{4, 11}, {1, 12}, {8, 3}, {12, 7}, {4, 2}, {7, 11}, {4, 8}, {9, 6}, {10, 11}, {6, 10}, {3, 5}, {11, 1}, {5, 3}, {11, 9}, {3, 8}});
        Arrays.stream(result2).forEach(System.out::println);
    }
}

class Solution2 {
    public int[] solution(int[][] edges) {
        return null;
    }
}