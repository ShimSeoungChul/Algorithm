package 백준.다이나믹프로그래밍;

import java.util.Scanner;
import java.util.stream.IntStream;
/*
3
2 100 100
2 1000 105
1000 2 1000
 */
public class N1149_RGB거리 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt(); // 집의 개수
		int[] R = new int[N];
		int[] G = new int[N];
		int[] B = new int[N];

		IntStream.range(0, N)
			.forEach(i -> {
				R[i] = sc.nextInt();
				G[i] = sc.nextInt();
				B[i] = sc.nextInt();
			});

		int[][] cache = new int[3][N];
		for (int i = 0; i < N; i++) {
			cache[0][i] = R[i];
			cache[1][i] = G[i];
			cache[2][i] = B[i];
		}

		for (int i = 1; i < N; i++) {
			cache[0][i] = cache[0][i] + Math.min(cache[1][i-1], cache[2][i-1]);
			cache[1][i] = cache[1][i] + Math.min(cache[0][i-1], cache[2][i-1]);
			cache[2][i] = cache[2][i] + Math.min(cache[0][i-1], cache[1][i-1]);
		}

		System.out.println(Math.min(Math.min(cache[0][N-1],cache[1][N-1]), cache[2][N-1]));

	}
}
