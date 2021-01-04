
import java.util.Scanner;

public class 숫자카드게임 {
    public static void main(String[] args){

        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt(); // 열 개수 1과 100 사이
        int M = scanner.nextInt(); // 행 개수 1과 100 사이

        //카드 숫자 입력
        int [][] cards = new int[N][M];
        for(int i=0;i<N;i++)
            for(int j=0; j<M;j++){
                cards[i][j] = scanner.nextInt();
            }

        scanner.close();

        int largestNum = 0;  // 결과 저장(각 행에서 가장 작은 숫자 중 가장 큰 숫자)
        int selectedNum = 0; // 각 행에서 가장 작은 숫자 저장

        for(int i=0;i<N;i++) {
            for (int j = 0; j < M; j++) {
                if(j == 0){ // 각 행의 첫 열의 숫자는 무조건 저장
                    selectedNum = cards[i][j];
                }else if (selectedNum > cards[i][j]){ // 첫 열 이후 더 작은 숫자가 나오면 저장
                    selectedNum = cards[i][j];
                }
            }

            // 현재 행의 가장 작은 숫자가 이전 행 들의 가장 작은 숫자 보다 크면 저장
            if(largestNum < selectedNum) {
                largestNum = selectedNum;
            }
        }

        System.out.println(largestNum); // 결과 출력

        //자세한 풀이 https://scshim.tistory.com/226
        //저자 코드 https://github.com/ndb796/python-for-coding-test/blob/master/3/4.java

    }
}
