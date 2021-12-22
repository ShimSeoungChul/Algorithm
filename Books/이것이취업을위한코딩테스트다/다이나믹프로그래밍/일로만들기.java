import java.util.Scanner;

/*
입력예시1
26
출력예시1
3
 */
public class 일로만들기 {
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		int X = sc.nextInt();

		int[] dp = new int[X+1];
		dp[2] = 1;
		dp[3] = 1;
		dp[5] = 1;

		for (int i = 4; i <= X; i++) {
			if (dp[i] % 5 == 0) {
				dp[i] = dp[i/5] + 1;
			} else if (dp[i] % 3 == 0) {
				dp[i] = dp[i/3] + 1;
			} else if (dp[i] % 2 == 0) {
				dp[i] = dp[i/5] + 1;
			} else {
				dp[i] = dp[i-1] + 1;
			}
		}

		System.out.println(dp[X]);
	}
}
