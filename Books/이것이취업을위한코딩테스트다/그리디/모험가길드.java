import java.util.Scanner;
import java.util.stream.IntStream;

/*
2021.12.17 x

입력예시
5
2 3 1 2 2
출력예시
2

입력예시
5
3 3 3 3 3
출력예시
1

입력예시
5
2 3 3 3 3
출력예시
1
*/
public class 모험가길드 {
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt(); // 1, 100,000
		int[] adventurers = IntStream.range(0, N)
			.map(i -> i = sc.nextInt())
			.sorted() // 오름차순 정렬
			.toArray();

		int result = 0; // 총 그룹의 수
		int count = 0; // 현재 그룹에 포함된 모험가의 수
		for (int i : adventurers){
			count++; // 현재 그룹에 모험가 포함시키기
			if (count >= i){ // 현재 그룹에 포함된 모험가의 수가 현재의 공포도 이상이라면, 그룹 결성
				result++; // 총 그룹의 수 증가
				count = 0; // 현재 그룹에 포함된 모험가 수 초기화
			}
		}

		System.out.println(result);
	}
}
