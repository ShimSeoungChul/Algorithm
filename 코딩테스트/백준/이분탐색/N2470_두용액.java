package 백준.이분탐색;

import java.util.Arrays;
import java.util.Scanner;

public class N2470_두용액 {
	static int N;
	static int[] A;

	public static void main(String args[]) {
		input();
		pro();
	}

	private static void input() {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		A = new int[N];
	}

	private static void pro() {
		Arrays.sort(A); // 이분 탐색을 위한 정렬

		int bestSum = Integer.MAX_VALUE;
		int v1 = 0, v2 = 0;

		for(int left = 1; left <= N -1; left++) {
			// A[left] 용액을 쓴다. 즉, -A[left]와 가장 가까운 용액을 자신의 오른쪽 구간에서 찾자.
			int res = lowerBound(A, left+1, N, -A[left]);

			// A[res-1]와 A[res] 중에 A[left]와 섞었을 때의 정보를 정답에 갱신시킨다.
			if (left + 1 <= res -1 && res -1 <= N && Math.abs(A[res-1] + A[left]) < bestSum) {
				bestSum = Math.abs(A[left] + A[res -1]);
				v1 = A[left];
				v2 = A[res - 1];
			}
			if (left + 1 <= res && res <= N && Math.abs(A[res] + A[left]) < bestSum) {
				bestSum = Math.abs(A[left] + A[res]);
				v1 = A[left];
				v2 = A[res];
			}
 		}
		StringBuilder sb = new StringBuilder();
		sb.append(v1).append(" ").append(v2);
		System.out.println(sb);
	}

	// A[L...R] 에서 X이상의 수 중 제일 왼쪽 인덱스를 return 하는 함수
	// 그런 게 없다면 R + 1을 return 한다.
	private static int lowerBound(int[] A, int L, int R, int X) {
		int res = R + 1;
		while(L <= R) {
			int mid = (L + R) / 2;
			if(A[mid] >= X) {
				res = mid;
				R = mid - 1;
			} else {
				L = mid + 1;
			}
		}
		return res;
	}
}
