import java.util.Scanner;
import java.util.stream.IntStream;

public class HARD_바닥공사 {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt(); // 1 <= N <= 1000
        int [] d = new int[N+1]; //결과 저장
        d[1] = 1;
        d[2] = 3;

        IntStream.rangeClosed(3,N)
                .forEach(x->d[x] = d[x-2]*2 + d[x-1]);

        int divisor = 796796; //결과를 나누는 수
        System.out.println(d[N]%divisor);
    }
}
