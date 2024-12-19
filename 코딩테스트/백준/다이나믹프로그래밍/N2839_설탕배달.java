package 백준.다이나믹프로그래밍;

import java.util.Arrays;
import java.util.Scanner;

/*
예제입력1
18
예제출력1
4
예제입력2
4
예제출력2
-1
 */
public class N2839_설탕배달 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt(); // 3 <= N <= 5000

		int[] cache = new int[5001];
		Arrays.fill(cache, Integer.MAX_VALUE);
		cache[3] = 1;
		cache[5] = 1;

		for (int i = 6; i <= N; i++) {
			if(cache[i-3] != Integer.MAX_VALUE || cache[i-5] != Integer.MAX_VALUE) {
				cache[i] = Math.min(cache[i-3], cache[i-5]) + 1;
			}
		}

		if (cache[N] != Integer.MAX_VALUE) {
			System.out.println(cache[N]);
		} else {
			System.out.println(-1);
		}
	}
}
