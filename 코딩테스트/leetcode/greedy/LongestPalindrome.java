package leetcode.greedy;

import java.util.HashMap;
import java.util.Map;

public class LongestPalindrome {
    void main() {
        System.out.println(longestPalindrome("abccccdd"));
        System.out.println(longestPalindrome("a"));
    }

    public static int longestPalindrome(String s) {
        Map<Character, Integer> strCountMap = new HashMap<>();
        for (char c: s.toCharArray()) {
            if (strCountMap.containsKey(c)) {
                int count = strCountMap.get(c);
                count++;
                strCountMap.put(c, count);
            } else {
                strCountMap.put(c, 1);
            }
        }

        boolean hasOddNumber = false;
        int totalCount = 0;

        for (int count: strCountMap.values()) {
            if (count % 2 == 1) {
                hasOddNumber = true;
                totalCount = totalCount + count - 1;
            } else {
                totalCount = totalCount + count;
            }
        }

        return hasOddNumber ? totalCount + 1 : totalCount;
    }
}
