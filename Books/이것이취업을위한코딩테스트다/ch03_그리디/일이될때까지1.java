
import java.util.Scanner;

public class 일이될때까지1 {
    static public void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();  // 2 <= N <= 100,000
        int K = scanner.nextInt();;  // 2 <= K <= 100,000

        int count = 0; //실행 횟수

        while(N!=1){    // N이 1이 될 떄까지 반
            // N이 K로 나누어 떨어질 경우 두 번째 연산 수행, 아닐 경우 첫 번째 연산 수행
            if(N == K*(N/K)){  // 조건을 (N % K == 0)으로 했으면 더 깔끔했음.
                N = N/K;
                count ++;
                continue; // 두 번째 연산 종료 후 반복문의 처음으로 돌아가기
            }

            N = N -1;
            count ++;
        }

        System.out.println(count);
    }
}
