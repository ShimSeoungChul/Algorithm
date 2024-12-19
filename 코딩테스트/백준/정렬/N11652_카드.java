package 백준.정렬;

import java.util.Scanner;
import java.util.stream.LongStream;
/*
6
111111111
111111111
111111111
5
7
3
 */
public class N11652_카드 {
	static int N;
	static long[] cards;

	public static void main(String[] args) {
		input();
		pro();
	}

	private static void pro() {
		long mode = Long.MAX_VALUE; // 최빈값
		long cur = Long.MAX_VALUE;// 현재 보고 있는 카드
		int modeCnt = 1, curCnt = 1; //최빈값 등장 횟수, 현재 보고 있는 카드 등장 횟수

		for (long card: cards) {
			if (cur != card) { // 카드 값이 변화함
				cur = card;
				curCnt = 1;
			} else {
				curCnt++;
			}

			if (curCnt > modeCnt) { // 최빈값 등장
				modeCnt = curCnt;
				mode = cur;
			}
		}
		System.out.println(mode);
	}

	private static void input() {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		cards = LongStream.range(0, N)
			.map(num -> num = sc.nextLong()) // 값 입력
			.sorted() // 오름차순 정렬
			.toArray();
	}
}
