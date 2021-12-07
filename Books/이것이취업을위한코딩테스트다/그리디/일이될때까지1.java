
import java.util.Scanner;

public class 일이될때까지1 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();  // 2 <= N <= 100,000
        int K = sc.nextInt();;  // 2 <= K <= 100,000

        int count = 0; // 연산을 한 횟수

        // N이 1이 되면 연산 종료
        while (N != 1){
            // N이 K로 나누어 떨어질 경우 나누고,
            if(N%K == 0){
                N = N/K;
            }else{ // 아닐 경우 1을 뺴기
                N -= 1;
            }
            count++;
        }

        System.out.println(count);
    }
}