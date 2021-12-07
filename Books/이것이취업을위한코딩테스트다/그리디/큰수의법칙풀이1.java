import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class 큰수의법칙풀이1 {
    public static void main(String[] args){
        int N, M, K;
        Scanner scanner = new Scanner(System.in);

        N = scanner.nextInt();
        M = scanner.nextInt();
        K = scanner.nextInt();

        Integer arr[] = new Integer[N];

        for(int i =0; i < N ; i++){
            arr[i] = scanner.nextInt();
        }
        scanner.close();

        // 입력 받은 숫자를 오름차순으로 정렬
        Arrays.sort(arr, Collections.reverseOrder());

        int result = 0;	// 결과의 합을 저장할 변수
        int count = 0;	// 연속으로 몇 번 숫자가 더해졌는지 기록하는 변수

        for(int i =0; i < M ; i++){
            if(count<K){
                //입력 받은 가장 큰 수를 연속으로 K번 미만으로 더한다.
                result += arr[0];
                count++;
            }else{
                //입력 받은 가장 큰 수를 연속으로 K번 이상 더했다면 두 번째로 큰 수를 한 번 더하고
                //count를 다시 0으로 초기화한다.
                result += arr[1];
                count = 0;
            }
        }

        System.out.println(result);

        //자세한 풀이 https://scshim.tistory.com/225
        //저자 코드 github.com/kva231/java-for-coding-test/blob/main/ch03_%EA%B7%B8%EB%A6%AC%EB%94%94/2.java
    }
}

