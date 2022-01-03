package 완전탐색;

import java.util.Scanner;
/*
중복을 허용하지 않으며, 순서 있게 나열하기
https://www.acmicpc.net/problem/14888﻿
 */
public class N14888_연산자끼워넣기 {
	static int N, max, min;
	static int[] nums, operators, order;

	private static void input() {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		nums = new int[N + 1];
		operators = new int[5];
		order = new int[N + 1];
		for (int i = 1; i <= N; i++) nums[i] = sc.nextInt();
		for (int i = 1; i <= 4; i++) operators[i] = sc.nextInt();

		max = Integer.MIN_VALUE;
		min = Integer.MAX_VALUE;
	}

	// 완성된 식에 맞게 계산을 해서 정답에 개신하는 작업
	static int calculator() {
		int value = nums[1];
		for (int i = 1; i < N; i++) {
			switch (order[i]) {
				case 1:
					value = value + nums[i+1];
					break;
				case 2:
					value = value - nums[i+1];
					break;
				case 3:
					value = value * nums[i+1];
					break;
				case 4:
					value = value / nums[i+1];
					break;
			}
		}
		return value;
	}

	// order[1...N-1]에 연산자들이 순서대로 저장
	private static void recurFun(int k) {
		if (k == N) { // 모든 연산자들을 전부 나열하는 방법을 찾은 상태
			// 정한 연산자 순서대로 계산해서 정답을 갱신하기
			int value = calculator();
			max = Math.max(max, value);
			min = Math.min(min, value);
		} else { // k 번째 연산자는 무엇을 선택할 것인가?
			// 4 가지의 연산자들 중에 뭘 쓸 것인지 선택하고 재귀 호출
			for (int cand = 1; cand <= 4; cand++) {
				if (operators[cand] >= 1) {
					operators[cand]--;
					order[k] = cand;
					recurFun(k+1);
					operators[cand]++;
					order[k] = 0;
				}
			}
		}
	}

	public static void main(String[] args) {
		input();
		recurFun(1);
		StringBuilder sb = new StringBuilder();
		sb.append(max).append('\n').append(min);
		System.out.println(sb);
	}
}
