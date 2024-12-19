package leetcode.slidingwindow;

import java.util.Set;

public class MaximumNumberOfVowelsInASubstringOfGivenLength {
    public void main() {
        // 테스트 케이스 1
        assert maxVowels("abciiidef", 3) == 3 : "Test case 1 failed";

        // 테스트 케이스 2
        assert maxVowels("aeiou", 2) == 2 : "Test case 2 failed";

        // 테스트 케이스 3
        assert maxVowels("leetcode", 3) == 2 : "Test case 3 failed";

        // 테스트 케이스 4
        assert maxVowels("a", 1) == 1 : "Test case 3 failed";

        System.out.println("All tests passed!");
    }


    public int maxVowels(String s, int k) {
        Set<Character> vowels = Set.of('a', 'e', 'i', 'o', 'u');
        char[] charArray = s.toCharArray();
        int start = 0;
        int end = k - 1;

        int vowelCount = 0;
        for (int i = 0; i < k; i++) {
            if (vowels.contains(charArray[i])) {
                vowelCount ++;
            }
        }

        int result = vowelCount;

        for (int i = k; i < charArray.length; i++) {
            if (vowels.contains(charArray[i-k])) {
                vowelCount--;
            }

            if (vowels.contains(charArray[i])) {
                vowelCount++;
            }

            result = Math.max(result, vowelCount);
        }

        return result;
    }
}
