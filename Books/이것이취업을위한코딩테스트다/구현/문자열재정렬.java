import java.util.ArrayList;
import java.util.Scanner;
import java.util.stream.IntStream;
/*
입력예시1
K1KA5CB7
출력예시1
ABCKK13

입력예시2
AJKDLSI412K4JSJ90
출력예시2
ADDIJJJKKLSS20
 */
public class 문자열재정렬 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String characters = sc.next();

		// 알파벳 필터링 후 오름차순 정렬
		var alphabets = new ArrayList<Character>();
		var numbers = new ArrayList<Character>();

		for (int i = 0; i < characters.length(); i++) {
			char character = characters.charAt(i);
			if (65 <= character && character <= 90){
				alphabets.add(character);
			} else {
				numbers.add(character);
			}
		}

		alphabets.sort((a,b)->a-b);

		int sum = numbers.stream()
			.mapToInt(number -> number)
			.sum();

		IntStream.range(0, alphabets.size())
			.forEach(i-> System.out.print(alphabets.get(i)));
		System.out.print(sum);
	}
}
