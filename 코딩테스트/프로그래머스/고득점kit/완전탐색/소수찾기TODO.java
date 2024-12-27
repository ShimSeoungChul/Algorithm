package 프로그래머스.고득점kit.완전탐색;

import java.util.HashSet;
import java.util.Set;

public class 소수찾기TODO {
    public static void main(String[] args) {
        Solution3 solution = new Solution3();
        System.out.println(solution.solution("17"));
        System.out.println(solution.solution("011"));
//        System.out.println(Integer.parseInt("00111"));
    }
}














class Solution3 {
    Set<Integer> numberSet;
    boolean[] visited;
    public int solution(String numbers) {
        numberSet = new HashSet<>();
        visited = new boolean[7];

        dfs(numbers, "", 0);

        int primeCount = 0;
        for (int number : numberSet) {
            if (isPrime(number)) primeCount++;
        }
        return primeCount;
    }

    public void dfs(String numbers, String prefix, int depth) {
        if (depth > numbers.length()) {
            return;
        }

        for (int i = 0; i < numbers.length(); i++) {
            if(!visited[i]) {
                visited[i] = true;
                int number = Integer.parseInt(prefix + numbers.charAt(i));
                numberSet.add(number);
                dfs(numbers, prefix + numbers.charAt(i), depth + 1);
                visited[i] = false;
            }
        }
    }

    // 에라토스테네스의 체
    public boolean isPrime(int number) {
        if (number < 2) {
            return false;
        }

        for (int i = 2; i <= Math.sqrt(number); i ++) {
            if (number % i == 0) {
                return false;
            }
        }

        return true;
    }
}
