
import java.util.Scanner;
import java.util.stream.IntStream;

/*
2021.12.12 x

입력 예시1
2
5 6
0 0 1 0
출력 예시1
30
30

입력 예시2
3
3 4 5
1 0 1 0
출력 예시2
35
17

입력 예시3
6
1 2 3 4 5 6
2 1 1 1
출력 예시3
54
-24

 */
public class 연산자끼워넣기 {
	static int N;
	static int A[];
	static int add;
	static int sub;
	static int mul;
	static int div;
	static int maxValue;
	static int minValue;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt(); // 수의 개수, 1 <= N <= 11
		A = IntStream.range(0, N)
			.map( i -> i = sc.nextInt())
			.toArray(); // 주어진 수

		// 부호의 개수
		add = sc.nextInt();
		sub = sc.nextInt();
		mul = sc.nextInt();
		div = sc.nextInt();

		maxValue = -1_000_000_000;
		minValue = 1_000_000_000;

		// 깊이 우선 탐색 시작
		dfs(1, A[0]);

		// 최댓값과 최솟값 차례대로 출력
		System.out.println(maxValue);
		System.out.println(minValue);
	}

	/* 깊이 우선 탐색
	 * @param i	  연산을자를 다 사용했는지 확인하기 위한 수
	 * @param now 연산을 수행한 값
	 */
	public static void dfs(int i, int now) {
		// 모든 연산자를 다 사용한 경우, 최솟값과 최댓값 업데이트
		if (i == N){
			minValue = Math.min(minValue, now);
			maxValue = Math.max(maxValue, now);
		}else{
			// 각 연산자에 대하여 재귀적으로 수행
			if (add > 0){
				add -= 1;
				dfs(i + 1, now + A[i]);
				add += 1;
			}

			if (sub > 0){
				sub -= 1;
				dfs(i + 1, now - A[i]);
				sub += 1;
			}

			if (mul > 0){
				mul -= 1;
				dfs(i + 1, now * A[i]);
				mul += 1;
			}

			if (div > 0){
				div -= 1;
				dfs(i + 1, now / A[i]);
				div += 1;
			}
		}
	}
}
