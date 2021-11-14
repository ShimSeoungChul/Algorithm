import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

/*
3
15
27
12
 */
public class 위에서아래로 {
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		int num = sc.nextInt();
		Integer[] arr = new Integer[num];

		for(int i = 0; i < num; i++){
			arr[i] = sc.nextInt();
		}

		Arrays.stream(arr)
			.sorted(Comparator.reverseOrder())
			.forEach(x-> System.out.print(x+" "));
	}
}
