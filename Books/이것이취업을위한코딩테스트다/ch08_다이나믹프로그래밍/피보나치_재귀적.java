public class 피보나치_재귀적 {
    public static void main(String[] args){
        System.out.println(fibo(7));
    }
    static int fibo(int x){
        if(x==1 || x==2) return 1;
        else return fibo(x-1) + fibo(x-2);
    }
}
