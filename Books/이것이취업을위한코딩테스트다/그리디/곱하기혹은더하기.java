import java.util.Scanner;

/*
2021.12.17 o

입력예시1
02984
출력예시1
576

입력예시2
567
출력예시2
210
 */
public class 곱하기혹은더하기 {
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		String s = sc.next();

		int result = s.charAt(0) - 48;
		for (int i = 1; i < s.length(); i++){
			int num = s.charAt(i) - 48;

			result = Math.max(result * num, result + num);
		}

		System.out.println(result);
	}
}
