import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;
import java.util.stream.IntStream;

/*
5 3
1 2 5 4 3
5 5 6 6 5
 */
public class 두배열의원소교체 {
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt(); // 배열의 원소 개수, 1 <= N <= 100,000
		int K = sc.nextInt(); // 바꿔치기 연산 횟수, 0 <= K <= N

		// 모든 원소는 10,000,000보다 작은 자연수
		int[] A = new int[N];
		Integer[] B = new Integer[N];

		// 숫자 입력
		IntStream.range(0,N)
			.forEach(i->A[i] = sc.nextInt());
		IntStream.range(0,N)
			.forEach(i->B[i] = sc.nextInt());

		// A를 오름차순으로, B를 내림차순으로 정렬
		Arrays.sort(A);
		Arrays.sort(B, Comparator.reverseOrder());

		// A에서 가장 작은 수와 B에서 가장 큰 수를 바꿔치기
		IntStream.range(0,K)
			.forEach(i->A[i] = B[i]);

		// 결과 출력
		int result = Arrays.stream(A).sum();
		System.out.println(result);
	}
}
