package 완전탐색;

import java.util.Scanner;

public class N9663_NQueen {

	static int N, ans;
	static int[] col; // col[i]: i번 행의 퀸은 col[i]번 열에 놓았다는 기록

	private static boolean attackable(int r1, int c1, int r2, int c2) {
		boolean result = false;
		if (c1 == c2) result = true; // 같은 열에서 공격 가능
		else if (r1 - c1 == r2 - c2) result = true; // 왼쪽 위 대각선으로 공격 가능
		else if (r1 + c1 == r2 + c2) result = true; // 오른쪽 위 대각선으로 공격 가능
		return result;
	}

	private static void recFunc(int row) {
		if (row == N + 1) {    // 각 행마다 퀸을 하나씩 놓음
			ans++;
		} else {
			for (int c = 1; c <= N; c++) {
				boolean possible = true;
				for (int i = 1; i <= row-1; i++){
					if(attackable(row, c, i, col[i])) {
						possible = false;
						break;
					}
				}

				if (possible) {
					col[row] = c;
					recFunc(row + 1);
					col[row] = 0;
				}
			}
		}
	}

	private static void input() {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		col = new int[N + 1];
	}

	public static void main(String[] args) {
		input();
		recFunc(1);
		System.out.println(ans);
	}
}
