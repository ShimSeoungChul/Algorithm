/*
21.12.23 x
입력 예시
5
7
3 8
8 1 0
2 7 4 4
4 5 2 6 5
출력 예시
30
 */

import java.util.Scanner;

public class 정수삼각형 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		var dp = new int[n][n];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < i + 1; j++) {
				dp[i][j] = sc.nextInt();
			}
		}

		// 다이나믹프로그래밍으로 2번째 줄까지 내려가면서 확인
		for (int i = 1; i < n; i++) {
			for (int j = 0; j < i + 1; j++) {
				int leftUp;
				int up;

				// 왼쪽 위에서 오는 경우
				if (j == 0) leftUp = 0;
				else leftUp = dp[i - 1][j - 1];

				// 위에서 오는 경우
				if (j == i) up = 0;
				else up = dp[i -1][j];

				dp[i][j] = dp[i][j] + Math.max(leftUp, up);
			}
		}

		int result = 0;
		for (int sum: dp[n-1]) {
			result = Math.max(result, sum);
		}

		System.out.println(result);
	}
}
