package 프로그래머스.기출.devmatching2021;

import java.util.HashSet;
import java.util.Set;

// https://school.programmers.co.kr/learn/courses/30/lessons/77484
public class 로또의최고순위와최저순위 {
    public void main() {
        int[] result = solution(new int[] {44, 1, 0, 0, 31, 25}, new int[] {31, 10, 45, 1, 6, 19});
        System.out.printf("%d%, d%n", result[0], result[1]);
        int[] result2 = solution(new int[] {0, 0, 0, 0, 0, 0}, new int[] {38, 19, 20, 40, 15, 25});
        System.out.printf("%d%, d%n", result2[0], result2[1]);
        int[] result3 = solution(new int[] {45, 4, 35, 20, 3, 9}, new int[] {20, 9, 3, 45, 4, 35});
        System.out.printf("%d%, d%n", result3[0], result3[1]);
    }

    public int[] solution(int[] lottos, int[] win_nums) {
        Set<Integer> lottoSet = new HashSet<>();
        for (int lotto: lottos) {
            if (lotto == 0) {
                continue;
            }
            lottoSet.add(lotto);
        }

        int zeroCount = 6 - lottoSet.size();
        int winCount = 0;

        for (int win_num: win_nums) {
            if (lottoSet.contains(win_num)) {
                winCount ++;
            }
        }

        int max = rank(winCount + zeroCount);
        int min = rank(winCount);
        return new int[] {max, min};
    }

    public int rank(int win_num) {
        return switch (win_num) {
            case 6 -> 1;
            case 5 -> 2;
            case 4 -> 3;
            case 3 -> 4;
            case 2 -> 5;
            default -> 6;
        };
    }
}
