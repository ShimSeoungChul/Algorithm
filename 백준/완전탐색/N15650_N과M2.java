package 완전탐색;

import java.util.Scanner;
/*
https://www.acmicpc.net/problem/15650
N개 중 중복 없이, M개를 고르기
 */
public class N15650_N과M2 {
	private static StringBuilder sb = new StringBuilder();
	private static int N;
	private static int M;
	private static int[] selected;

	private static void input() {
		Scanner scan = new Scanner(System.in);
		N = scan.nextInt();
		M = scan.nextInt();
		selected = new int[M + 1];
	}

	private static void rec_func(int k) {
		if (k == M + 1) { // 모두 고름
			// selected[1...M] 배열이 새롭게 탑색된 결과
			for (int i = 1; i <= M; i++) {
				sb.append(selected[i]).append(' ');
			}
			sb.append('\n');
		} else {
			for (int cand = selected[k-1] + 1; cand <= N; cand++) {

				// 사용 처리
				selected[k] = cand;

				// 매번 k+1 번부터 M번 원소로 재귀 호출
				rec_func(k + 1);

				// 사용 후 반납
				selected[k] = 0;
			}
		}
	}

	public static void main(String[] args) {
		input();
		rec_func(1);
		System.out.println(sb.toString());
	}
}

