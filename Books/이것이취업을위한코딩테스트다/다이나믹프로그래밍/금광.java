import java.util.Scanner;

/*
22021.12.22 x
입력예시
3 4
1 3 3 2 2 1 4 1 0 6 4 7
4 4
1 3 1 5 2 2 4 1 5 0 2 3 0 6 1 2
출력예시
19
16
 */
public class 금광 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();

		for (int i = 0; i < T; i++) {
			int n = sc.nextInt();
			int m = sc.nextInt();

			int[][] graph = new int[n][m];
			int[][] dp = new int[n][m];
			for (int j = 0; j < n; j++) {
				for (int k = 0; k < m; k++) {
					graph[j][k] = sc.nextInt();
					dp[j][k] = graph[j][k];
				}
			}
			getMaxGold(dp, n, m);
			sc.nextLine();
		}

		sc.close();
	}

	public static void getMaxGold(int[][] dp, int n, int m) {
		for (int j = 1; j < m; j++) {
			for (int i = 0; i < n; i++) {
				int leftUp, leftDown, left;
				// 왼쪽 위에서는 오는 경우
				if (i == 0) leftUp = 0;
				else leftUp = dp[i - 1][j - 1];
				// 왼쪽 아래에서 오는 경우
				if (i == n - 1) leftDown = 0;
				else leftDown = dp[i + 1][j - 1];
				// 왼쪽에서 오는 경우
				left = dp[i][j - 1];
				dp[i][j] = dp[i][j] + Math.max(leftUp, Math.max(leftDown, left));
			}
		}
		int result = 0;
		for (int i = 0; i < n; i++){
			result = Math.max(result, dp[i][m - 1]);
		}
		System.out.println(result);
	}

}
