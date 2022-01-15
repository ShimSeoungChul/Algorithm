package 완전탐색;

import java.util.Scanner;

/*
중복을 허용하지 않으며, 순서 있게 나열하기
https://www.acmicpc.net/problem/14888﻿
 */
public class N14888_연산자끼워넣기_enhanced {
	static int N, max, min;
	static int[] nums, operators;

	private static void input() {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		nums = new int[N + 1];
		operators = new int[5];
		for (int i = 1; i <= N; i++)
			nums[i] = sc.nextInt();
		for (int i = 1; i <= 4; i++)
			operators[i] = sc.nextInt();

		max = Integer.MIN_VALUE;
		min = Integer.MAX_VALUE;
	}

	// 피연산자 2개와 연산자가 주어졌을 때 계산해주는 함수
	static int calculator(int operand1, int operator, int operand2) {
		int result = 0;
		switch (operator) {
			case 1:
				result = operand1 + operand2;
				break;
			case 2:
				result = operand1 - operand2;
				break;
			case 3:
				result = operand1 * operand2;
				break;
			case 4:
				result = operand1 / operand2;
				break;
		}
		return result;
	}

	// order[1...N-1]에 연산자들이 순서대로 저장
	private static void recurFun(int k, int value) {
		if (k == N) { // 모든 연산자들을 전부 나열하는 방법을 찾은 상태
			// 정한 연산자 순서대로 계산해서 정답을 갱신하기
			max = Math.max(max, value);
			min = Math.min(min, value);
		} else { // k 번째 연산자는 무엇을 선택할 것인가?
			// 4 가지의 연산자들 중에 뭘 쓸 것인지 선택하고 재귀 호출
			for (int cand = 1; cand <= 4; cand++) {
				if (operators[cand] >= 1) {
					operators[cand]--;
					int sum = calculator(value, cand, nums[k + 1]);
					recurFun(k + 1, sum);
					operators[cand]++;
				}
			}
		}
	}

	public static void main(String[] args) {
		input();
		recurFun(1, nums[1]);
		StringBuilder sb = new StringBuilder();
		sb.append(max).append('\n').append(min);
		System.out.println(sb);
	}
}
