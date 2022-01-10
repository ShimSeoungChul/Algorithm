package 이분탐색;

import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.IntStream;

public class N7795 {
	static Scanner sc = new Scanner(System.in);
	static int T;
	static int N, M;
	static int[] A, B;
	public static void main(String[] args) {
		T = sc.nextInt();
		for (int i = 0; i < T; i++) {
			input();
			pro();
		}

		sc.close();
	}

	private static void pro() {
		// B배열에 대해 이분탐색을 하기 위해 정렬한다.
		Arrays.sort(B);

		int ans = 0;
		for (int i = 1; i <= N; i++) {
			//A[i]를 선택하면, B에서는 A[i]보다 작은 게 몇 개나 있는 지 count하기
			ans += lowerBound(B, 1, M, A[i]);/* TODO */
		}
		System.out.println(ans);
	}

	/*
     * A[L...R]에서 X미만의 수 중 제일 오른쪽 인덱스를 Return 하는 함수
     * 일치하는 수가 없다면 L -1을 return
	 */
	private static int lowerBound(int[] A, int L, int R, int X) {
		int result = L - 1;
		while(L <= R) {
			int mid = (L + R) /2;
			if (A[mid] < X) {
				L = mid + 1;
				result = mid;
			} else if (A[mid] >= X) {
				R = mid - 1;
			}
		}
		return result;
	}

	private static void input() {
		N = sc.nextInt();
		M = sc.nextInt();
		A = new int[N+1];
		B = new int[M+1];
		IntStream.range(1, N+1)
			.forEach(i -> A[i] = sc.nextInt());
		IntStream.range(1, M+1)
			.forEach(i -> B[i] = sc.nextInt());
	}
}
