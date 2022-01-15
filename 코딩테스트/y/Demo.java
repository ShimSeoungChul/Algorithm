package y;

import java.util.Arrays;
import java.util.Scanner;

public class Demo {
	private static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		Demo main = new Demo();
		int[] A = {-1, -3};
		main.solution(A);
		sc.close();
	}

	public int solution(int[] A) {
		Arrays.sort(A);
		int result = pro(A);
		return result;
	}

	private int pro(int[] A) {
		int result = 0;
		
		for (int posInt = 1; posInt <= A.length + 1; posInt++) {
			boolean hasPosInt = false;
			int l = 0;
			int r = A.length - 1;

			while (l <= r) {
				int mid = (l + r) / 2;
				if (A[mid] < posInt) {
					l = mid + 1;
				} else if (A[mid] > posInt) {
					r = mid - 1;
				} else if (A[mid] == posInt) {
					hasPosInt = true;
					break;
				}
			}

			if (!hasPosInt) {
				result = posInt;
				break;
			} 
		}
		return result;
	}
}
