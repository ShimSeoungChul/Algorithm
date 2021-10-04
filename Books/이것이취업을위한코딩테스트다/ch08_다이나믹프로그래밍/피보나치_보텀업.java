import java.util.Arrays;
import java.util.stream.IntStream;
import java.util.stream.LongStream;

public class 피보나치_보텀업 {
    public static void main(String[] arsgs){
        System.out.println(fibo(7));
    }
    static long fibo(int x){
        //한 번 계산된 결과를 메모이제이션하기 위한 리스트 초기화
        Long []cache = new Long[x];
        //첫 번째, 두 번째 피보나치 수는 1
        cache[0] = 1L;
        cache[1] = 1L;

        //피보나치를 반복으로 구현
        IntStream.range(2,x).forEach(num-> cache[num] = cache[num-1]+cache[num-2]);

        return cache[x-1];
    }
}
