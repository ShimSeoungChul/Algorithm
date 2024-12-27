package 프로그래머스.고득점kit.완전탐색;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class 모의고사 {
    public static void main() {
        Solution2 solution = new Solution2();
        System.out.println(Arrays.toString(solution.solution(new int[]{1, 2, 3, 4, 5})));
        System.out.println(Arrays.toString(solution.solution(new int[]{1,3,2,4,2})));
    }
}

class Solution2 {
    public int[] solution(int[] answers) {
        List<Integer> highestMembers = new ArrayList<>();
        int [][] rules = new int[][] {{1, 2, 3, 4, 5}, {2, 1, 2, 3, 2, 4, 2, 5}, {3, 3, 1, 1, 2, 2, 4, 4, 5, 5}};
        int[] memberScores = new int[3];

        for (int i = 0; i  < answers.length; i++) {
            for (int j = 0; j < 3; j ++) {
                if (rules[j][i % rules[j].length] == answers[i]) memberScores[j] += 1;
            }
        }

        int highestScore = Math.max(memberScores[0], Math.max(memberScores[1], memberScores[2]));
        for (int i = 0; i < 3; i ++) {
            if (memberScores[i] == highestScore) highestMembers.add(i+1);
        }

        return highestMembers.stream().mapToInt(Integer::intValue).toArray();
    }
}