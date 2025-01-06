package 프로그래머스.고득점kit.DFS_BFS;

// https://school.programmers.co.kr/learn/courses/30/lessons/43165
public class 타겟넘버 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.solution(new int[] {1, 1}, 2)); // 1
        Solution solution2 = new Solution();
        System.out.println(solution2.solution(new int[] {1, 1, 1, 1, 1}, 3));  // 5
        Solution solution3 = new Solution();
        System.out.println(solution3.solution(new int[] {4, 1, 2, 1}, 4));  // 2
    }
}

class Solution {
    int answer = 0;
    public int solution(int[] numbers, int target) {
        dfs(numbers, 0, 0, target);
        return answer;
    }

    public void dfs(int[] numbers, int sum, int index, int target) {
        if (index == numbers.length) {
            if (sum == target) {
                answer += 1;
            }
            return;
        }

        int number = numbers[index];
        dfs(numbers, sum + number, index + 1, target);
        dfs(numbers, sum - number, index + 1, target);
    }
}

/*
재귀 함수를 통해 numbers를 순회하며 number가 +인 경우, -인 경우 각각 값을 더해 모든 경우의 수를 확인한다.
함수 호출에 numbers의 인덱스도 함께 입력한다. 함수에서 numbers의 인덱스가 마지막인 경우 합계가 target과 같으면 answer에 1을 더한다.
 */