package 프로그래머스.기출.kakaowinterintership2024;

import java.util.HashMap;
import java.util.Map;

public class 가장많이받은선물 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int result = solution.solution(
                new String[] {"muzi", "ryan", "frodo", "neo"},
                new String[] {"muzi frodo", "muzi frodo", "ryan muzi", "ryan muzi", "ryan muzi", "frodo muzi", "frodo ryan", "neo muzi"}
        );
        System.out.println(result);
    }
}

class Solution {

    Map<String, Integer> friendMap = new HashMap<>();
    Map<Integer, Integer> predictionMap = new HashMap<>();

    public int solution(String[] friends, String[] gifts) {
        for (int i = 0; i < friends.length; i++) {
            friendMap.put(friends[i], i);
        }

        int[][] giftTable = new int[friends.length][friends.length];
        int[] giftIndexTable = new int[friends.length];
        for (String gift: gifts) {
            String[] names = gift.split(" ");
            int giverIndex = friendMap.get(names[0]);
            int takerIndex = friendMap.get(names[1]);
            giftTable[giverIndex][takerIndex] += 1;
            giftIndexTable[giverIndex] += 1;
            giftIndexTable[takerIndex] -= 1;
        }

        int max = 0;
        for (int i = 0; i < friends.length; i++)
            for (int j = 0; j < friends.length; j++) {
                if (i == j) continue;

                int current = predictionMap.getOrDefault(i, 0);
                if (giftTable[i][j] > giftTable[j][i]) {
                    predictionMap.put(i, ++current);
                } else if (giftTable[i][j] == giftTable[j][i] && giftIndexTable[i] > giftIndexTable[j]) {
                    predictionMap.put(i, ++current);
                }
                max = Math.max(max, current);
            }

        return max;
    }
}