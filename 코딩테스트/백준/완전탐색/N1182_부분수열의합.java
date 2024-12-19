package 백준.완전탐색;

import java.util.Scanner;

public class N1182_부분수열의합 {
	static int N, S, ans;
	static int[] nums;

	public static void main(String[] args) {
		input();
		recFunc(1, 0);
		// ans가 정말 "진 부분집합(비어있지 않은 부분집합)"만 다루는 지 확인하기
		if (S == 0) ans --;
		System.out.println(ans);
	}

	// k번쨰 원소를 포함시킬 지 정하는 함수
	// value: k-1 번째 원소까지 골라진 원소들의 합
	private static void recFunc(int k, int value) {
		if (k == N + 1) { // 부분 수열을 하나 완성 시킨 상태
			// value가 S와 같은 지 확인하기
			if (value == S) ans++;
		} else {
			// k 번째 원소를 포함시킬 지 결정하고 재귀 호출
			// Include
			recFunc(k+1, value + nums[k]);
			// Not Include
			recFunc(k + 1, value);
		}
	}

	private static void input() {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		S = sc.nextInt();
		nums = new int[N + 1];
		for (int i = 1; i < nums.length; i++) {
			nums[i] = sc.nextInt();
		}
	}
}
