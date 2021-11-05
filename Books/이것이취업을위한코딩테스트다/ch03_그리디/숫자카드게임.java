
import java.util.Scanner;

public class 숫자카드게임 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt(); // 행의 개수 1 <= N <= 100
        int M = sc.nextInt(); // 열의 개수 1 <= M <= 100

        int result = 0; // 결과

        for(int i = 0; i < N; i ++){
            int min = 100; // 각 행에서 가장 작은 값을 저장
            for(int j = 0; j < M; j++){
                int num = sc.nextInt();
                if(min > num){
                    min = num;
                }
            }
            // 각 행에서 가장 낮은 숫자 카드 중에 가장 큰 숫자를 입력
            if(result < min){
                result = min;
            }
        }
        System.out.println("결과: " + result);
    }
}
