package 프로그래머스.기출.kakaowinterintership2024;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class 도넛과막대그래프 {
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
        int linkPoint = 0;
        int donutCount = 0;
        int stickCount = 0;
        int eightCount = 0;

        Map<Integer, Integer> out = new HashMap<>();
        Map<Integer, Integer> in = new HashMap<>();

        for (int[] edge: edges) {
            out.put(edge[0], out.getOrDefault(edge[0], 0) + 1);
            in.put(edge[1], in.getOrDefault(edge[0], 0) + 1);
        }

        for (int node: out.keySet()) {
            if (out.get(node) > 1) {
                if (!in.containsKey(node)) {
                    linkPoint = node;
                } else {
                    eightCount += 1;
                }
            }
        }

        for (int node: in.keySet()) {
            if (!out.containsKey(node)) {
                stickCount += 1;
            }
        }
        donutCount = out.get(linkPoint) - stickCount - eightCount;
        return new int[] {linkPoint, donutCount, stickCount, eightCount};
    }
}