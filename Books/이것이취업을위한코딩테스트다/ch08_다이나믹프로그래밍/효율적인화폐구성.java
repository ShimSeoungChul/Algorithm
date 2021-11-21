
import java.util.Scanner;
import java.util.stream.IntStream;
/*
2 15
2
3

2 6
2
3

3 4
3
5
7
 */
public class 효율적인화폐구성 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt(); // N가지 종류의 화페, 1 <= N <= 100
        int M = sc.nextInt(); // 화폐의 가치 합 M, 1 <= M <= 10,000

        // 화폐의 종류 입력
        int[] coins = IntStream.range(0,N)
            .map(i->sc.nextInt())
            .sorted()
            .toArray();

        // 한 번 계산된 결과를 저장하기 위한 DP 테이블 초기화
        int[] cache = IntStream.rangeClosed(0,M)
            .map(i->10000)
            .toArray();

        for(int coin: coins){
            if(coin <= M){
                cache[coin] = 1;
            }
        }

        // DP 보텀업 방식 진행
        for(int i = 1; i <= M; i++){
            for(int coin: coins){
                if(cache[i] != 10000 && (i + coin) <= M){
                    cache[i+coin] = Math.min(cache[i+coin], cache[i]+1);
                }
            }
        }

        // 결과 출력
        if(cache[M] == 10000){
            System.out.println(-1);
        }else{
            System.out.println(cache[M]);
        }
    }
}
