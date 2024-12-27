package 프로그래머스.고득점kit.완전탐색;

import java.util.ArrayList;
import java.util.List;

public class 모음사전TODO {
    public static void main(String[] args) {
        Solution7 solution = new Solution7();
        System.out.println(solution.solution("AAAAE")); // 6
        System.out.println(solution.solution("AAAE")); // 10
        System.out.println(solution.solution("I")); // 1563
        System.out.println(solution.solution("EIO")); // 1189
    }
}

class Solution7 {
    List<String> vowels = List.of("A", "E", "I", "O", "U");
    List<String> words;
    public int solution(String word) {
        words = new ArrayList<>();
        dfs("", 0);
        return findWordPosition(word);
    }

    public int findWordPosition(String word) {
        int start = 1;
        int end = words.size() - 1;

        while (start <= end) {
            int mid = (end + start) / 2;
            if (word.compareTo(words.get(mid)) == 0) {
                return mid;
            } else if (word.compareTo(words.get(mid)) < 0) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }

        return -1;
    }

    public void dfs(String str, int len) {
        words.add(str);

        if (len == 5) {
            return;
        }

        for (int i = 0; i < 5; i++) {
            dfs(str + vowels.get(i), len + 1);
        }
    }
}