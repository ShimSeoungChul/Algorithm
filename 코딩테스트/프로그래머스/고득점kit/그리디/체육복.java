package 프로그래머스.고득점kit.그리디;

import java.util.*;

public class 체육복 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.solution(5,new int[] {2, 4}, new int[] {1, 3, 5})); // 5
        System.out.println(solution.solution(5,new int[] {2, 4}, new int[] {3})); // 4
        System.out.println(solution.solution(3,new int[] {3}, new int[] {1})); // 2
        System.out.println(solution.solution(5,new int[] {4, 2}, new int[] {3, 5})); // 5
        System.out.println(solution.solution(5,new int[] {2, 4}, new int[] {3, 4})); // 5
        System.out.println(solution.solution(5, new int[] {2, 3}, new int[] {3})); // 4
    }
}

class Solution {
    public int solution(int n, int[] lost, int[] reserve) {
        List<Integer> lostList = new ArrayList<>();
        for (int j : lost) {
            lostList.add(j);
        }
        Collections.sort(lostList);
        HashSet<Integer> lostSet = new HashSet<>(lostList);

        Set<Integer> reserveSet = new HashSet<>();
        for (int j : reserve) {
            reserveSet.add(j);
        }

        int recover = 0;
        for (int value: lostList) {
            if (reserveSet.contains(value-1) && !lostSet.contains(value-1)) {
                recover++;
                reserveSet.remove(value-1);
                continue;
            }

            if (reserveSet.contains(value)) {
                recover++;
                reserveSet.remove(value);
                continue;
            }

            if (reserveSet.contains(value+1) && !lostSet.contains(value+1)) {
                recover++;
                reserveSet.remove(value+1);
            }
        }


        return n - lost.length + recover;
    }
}