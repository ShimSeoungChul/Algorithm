package 프로그래머스.고득점kit.해시;

import java.util.*;

public class 폰켓몬 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.solution(new int[] {3, 1, 2, 3})); // 2
        System.out.println(solution.solution(new int[] {3, 3, 3, 2, 2, 4})); // 3
        System.out.println(solution.solution(new int[] {3, 3, 3, 2, 2, 2})); // 2
    }
}

class Solution {
    public int solution(int[] nums) {
        Map<Integer, Integer> poketmonMap = new HashMap<>();
        Set<Integer> poketmonCategory = new HashSet<>();

        for (int num: nums) {
            if (poketmonMap.containsKey(num)) {
                poketmonMap.put(num, poketmonMap.get(num) + 1);
            } else{
                poketmonMap.put(num, 1);
            }
        }

        int N = nums.length / 2;
        int poketmonCount = 0;

        while(poketmonCount != N) {
            List<Integer> deleteTargets = new ArrayList<>();
            for (int key: poketmonMap.keySet()) {
                poketmonCategory.add(key);
                poketmonCount += 1;

                if (poketmonCount == N) {
                    break;
                }

                int remain = poketmonMap.get(key);
                remain -= 1;

                if (remain == 0) deleteTargets.add(key);

                poketmonMap.put(key, remain - 1);
            }

            for (int deleteTarget : deleteTargets) poketmonMap.remove(deleteTarget);
        }

        return poketmonCategory.size();
    }
}