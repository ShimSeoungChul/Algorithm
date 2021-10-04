public class 피보나치_메모이제이션 {
    public static void main(String[] arsgs){
        //한 번 계산된 결과를 메모이제이션하기 위한 리스트 초기화
        long []cache = new long[100];
        System.out.println(fibo(7,cache));

    }
    static long fibo(int x, long[] cache){
        System.out.print("f("+x+") ");
        //종료 조건
        if(x == 1 || x == 2)
            return 1;
        //이미 계산한 적 있는 문제라면 그대로 반환
        if (cache[x] != 0)
            return cache[x];
        //아직 계산하지 않은 문제라면 점화식에 따라 피보나치 결과 변환
        cache[x] = fibo(x-1, cache) + fibo(x-2,cache);

        return cache[x];
    }
}
