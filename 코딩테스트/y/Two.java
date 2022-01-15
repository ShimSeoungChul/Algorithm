package y;

import java.util.Arrays;

public class Two {
	public static void main(String args[]) {
		Two main = new Two();
		//int[] A = {1,2,1};
		int[] A = {2, 1, 4, 4};
		//int[] A = {6,2,3,5,6,3};
		int result = main.solution(A);
		System.out.println(result);
	}

	public int solution(int[] A) {
		Arrays.sort(A);
		int result = getSmallestNumberOfMove(A);
		if(result >= 1_000_000_000) result = -1;
		return result;
	}

	private int getSmallestNumberOfMove(int[] A) {
		int result = 0;
		for (int i = 0; i < A.length; i++) {
			int expected = i + 1;
			int diff = Math.abs(expected - A[i]);
			result += diff;
		}
		return result;
	}
}
