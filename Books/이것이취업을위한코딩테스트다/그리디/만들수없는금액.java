import java.util.Scanner;
import java.util.stream.IntStream;

/*
2021.12.18 x

입력예시
5
3 2 1 1 9
출력예시
8
 */
public class 만들수없는금액 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[] conis = IntStream.range(0, N)
			.map(i -> i = sc.nextInt())
			.sorted()
			.toArray();

		int target = 1;
		for (int x : conis) {
			if (target < x){
				break;
			}
			target += x;
		}

		System.out.println(target);
	}
}
