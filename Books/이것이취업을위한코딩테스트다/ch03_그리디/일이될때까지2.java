import java.util.Scanner;

public class 일이될때까지2 {
    static public void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();  // 2 <= N <= 100,000
        int K = scanner.nextInt();;  // 2 <= K <= 100,000

        int count = 0; //실행 횟수

        while(N!=1){    // N이 1이 될 떄까지 반
            // N이 K로 나누어 떨어질 경우 두 번째 연산 수행, 아닐 경우 첫 번째 연산 수행
            if(N % K == 0){
                N = N/K;
                count ++;
                continue; // 두 번째 연산 종료 후 반복문의 처음으로 돌아가기
            }

            // N이 나누어 떨어질 때까지 1씩 빼기
            int target = (N/K) * K;
            count +=  (N - target);
            N = N - target;
        }

        System.out.println(count);
        
         //자세한 풀이 https://scshim.tistory.com/227
        //저자 코드 https://github.com/ndb796/python-for-coding-test/blob/master/3/2.java
    }
}
