package y;

public class One {
	public static void main(String args[]) {
		One main = new One();
		int result = main.solution(125);
		System.out.println(result);
	}

	public int solution(int N) {
		int result = getSmallestNumber(N);
		if(result == 1) result = 0;
		return result;
	}

	private int getSmallestNumber(int N) {
		String number = Integer.toString(N);
		int numOfDigits = number.length();
		return (int)Math.pow(10, numOfDigits - 1);
	}
}
