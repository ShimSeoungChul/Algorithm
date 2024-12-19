package 프로그래머스.기출.devmatching2021;

import java.util.*;

// https://school.programmers.co.kr/learn/courses/30/lessons/77486
public class 다단계칫솔판매TODO {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] result = solution. solution(
                new String[] {"john", "mary", "edward", "sam", "emily", "jaimie", "tod", "young"},
                new String[] {"-", "-", "mary", "edward", "mary", "mary", "jaimie", "edward"},
                new String[] {"young", "john", "tod", "emily", "mary"},
                new int[] {12, 4, 2, 5, 10});
        Arrays.stream(result).forEach(System.out::println);
    }
}


















class Solution{
    Map<String, String> parent = new HashMap<>();
    Map<String, Integer> money = new HashMap<>();

    public int[] solution(String[] enroll, String[] referral, String[] seller, int[] amount) {
        for (int i = 0; i < enroll.length; i++) {
            parent.put(enroll[i], referral[i]);
        }

        for (int i = 0; i < seller.length; i++) {
            share(seller[i], amount[i] * 100);
        }

        int[] result = new int[enroll.length];
        for (int i = 0; i < enroll.length; i++) {
            result[i] = money.getOrDefault(enroll[i], 0);
        }

        return result;
    }

    void share(String node, int sales) {
        int nextSales = sales / 10;
        money.put(node, money.getOrDefault(node, 0) + sales - nextSales);

        if (nextSales > 0 && parent.containsKey(node)) {
            share(parent.get(node), nextSales);
        }
    }
}
