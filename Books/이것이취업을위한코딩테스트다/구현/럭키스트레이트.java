import java.util.Scanner;
import java.util.stream.IntStream;

/*
입력예시1
123402
출력예시1
LUCKY

입력예시2
7755
출력예시2
READY
 */
public class 럭키스트레이트 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String score = sc.next();
		String left = score.substring(0, score.length() / 2);
		String right = score.substring(score.length() / 2);

		int leftSum = IntStream.range(0, left.length())
			.map(i -> left.charAt(i) - 48)
			.sum();

		int rightSum = IntStream.range(0, right.length())
			.map(i -> right.charAt(i) - 48)
			.sum();

		if (leftSum == rightSum) {
			System.out.println("LUCKY");
		} else {
			System.out.println("READY");
		}
	}
}
