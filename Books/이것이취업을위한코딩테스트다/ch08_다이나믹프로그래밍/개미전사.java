import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.IntStream;
/*
4
1 3 1 5
 */
public class 개미전사 {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt(); // N >= 3
        int[] foodArr = new int[N];
        IntStream.range(0,N)
                .forEach(x->foodArr[x] = scanner.nextInt());

        int[] calculate = new int[N];
        calculate[0] = foodArr[0];
        calculate[1] = Math.max(foodArr[0],foodArr[1]);

        IntStream.range(2,N)
                .forEach(x-> {
                    System.out.println(x);
                    calculate[x] = Math.max(calculate[x-1], calculate[x-2]+foodArr[x]);
                    System.out.println(x);
                });

        int result = calculate[N-1];
        System.out.println(result);
    }
}
