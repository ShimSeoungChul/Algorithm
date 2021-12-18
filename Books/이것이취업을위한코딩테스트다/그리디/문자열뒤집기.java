import java.util.Scanner;

/*
2021.12.18 o

입력예시
0001100
출력예시
1
 */
public class 문자열뒤집기 {
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		String s = sc.next();


		int countOfOne = 0; // 1을 뒤집는데 걸리는 횟수
		int countOfZero = 0; // 0을 뒤집는데 걸리는 횟수
		boolean isOneLine = false;
		boolean isZeroLine = false;

		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) - 48 == 1) {
				// 이전 수가 1이 아닌 경우
				if (!isOneLine) {
					countOfOne++;
				}
				isOneLine = true;
			} else {
				// 이전 수가 0이 아닌 경우
				if (!isZeroLine) {
					countOfZero++;
				}
				isZeroLine = true;
			}
		}

		System.out.println(Math.min(countOfOne,countOfZero));

	}
}
