package 백준.다이나믹프로그래밍;

import java.util.Scanner;

public class N1003_피노나치함수 {

	private static int[] dp = new int[41];
	private static int[] zeroCount = new int[41];
	private static int[] oneCount = new int[41];

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();

		dp[0] = 0;
		dp[1] = 1;
		dp[2] = 1;
		zeroCount[0] = 1;
		zeroCount[1] = 0;
		zeroCount[2] = 1;
		oneCount[0] = 0;
		oneCount[1] = 1;
		oneCount[2] = 1;

		for (int i = 0; i < T; i++) {
			int n = sc.nextInt();
			fibonacci(n);
		}
	}

	private static void fibonacci(int n) {
		for (int i = 3; i <= n; i++) {
			dp[i] = dp[i - 2] + dp[i - 1];
			zeroCount[i] = zeroCount[i - 2] + zeroCount[i - 1];
			oneCount[i] = oneCount[i - 2] + oneCount[i - 1];
		}

		System.out.println(zeroCount[n] + " " + oneCount[n]);
	}
}
