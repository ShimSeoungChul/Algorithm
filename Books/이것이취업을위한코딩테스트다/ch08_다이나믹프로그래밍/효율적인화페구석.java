import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.IntStream;
/*
2 15
2
3
 */
public class 효율적인화페구석 {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        int N,M;
        N = scanner.nextInt(); // 1 <= N <= 100
        M = scanner.nextInt(); // 1 <= M <= 10,000

        int [] coinArr = new int[N+1];
        IntStream.rangeClosed(1,N)
                .forEach(x->coinArr[x] = scanner.nextInt());



        int []d = new int[M+1];

    }
}
