package 인강.딩코딩코.정렬_스택_큐_해쉬;

import java.util.Stack;

// https://school.programmers.co.kr/learn/courses/30/lessons/12909
// 올바른 괄호
public class Q2TODO {
    public static void main(String[] args) {
        System.out.println("정답 = true / 현재 풀이 값 = " + isCorrectParenthesis("(())"));
        System.out.println("정답 = true / 현재 풀이 값 = " + isCorrectParenthesis("(())()"));
        System.out.println("정답 = false / 현재 풀이 값 = " + isCorrectParenthesis(")"));
        System.out.println("정답 = false / 현재 풀이 값 = " + isCorrectParenthesis(")()("));
        System.out.println("정답 = false / 현재 풀이 값 = " + isCorrectParenthesis("((())))"));
        System.out.println("정답 = false / 현재 풀이 값 = " + isCorrectParenthesis("())()"));
        System.out.println("정답 = false / 현재 풀이 값 = " + isCorrectParenthesis("((())"));

        System.out.println("정답 = true / 현재 풀이 값 = " + isCorrectParenthesis2("(())"));
        System.out.println("정답 = true / 현재 풀이 값 = " + isCorrectParenthesis2("(())()"));
        System.out.println("정답 = false / 현재 풀이 값 = " + isCorrectParenthesis2(")"));
        System.out.println("정답 = false / 현재 풀이 값 = " + isCorrectParenthesis2(")()("));
        System.out.println("정답 = false / 현재 풀이 값 = " + isCorrectParenthesis2("((())))"));
        System.out.println("정답 = false / 현재 풀이 값 = " + isCorrectParenthesis2("())()"));
        System.out.println("정답 = false / 현재 풀이 값 = " + isCorrectParenthesis2("((())"));
    }

    // 내 풀기
    public static boolean isCorrectParenthesis(String s) {
        int left = 0;
        int right = 0;

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') left++;
            if (s.charAt(i) == ')') {
                right++;
                if (left < right) return false;
            }
        }

        return left == right;
    }

    // 강사님 풀이
    public static boolean isCorrectParenthesis2(String s) {
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') stack.add('(');
            if (s.charAt(i) == ')') {
                if (stack.isEmpty()) return false;
                stack.pop();
            }
        }

        return stack.isEmpty();
    }
}

// 방법 1. '('와 ')'의 개수가 같아야한다. '('가 나오기 전에 ')'가 나오면 실패한다. -> 조건문으로 풀기
// 방법 2. ')'가 나오면, 바로 직전에 열렸던 괄호가 닫힌다. '('가 나오면 순서대로 쌓아 저장해둔다. -> 스택을 이용해서 푼다.