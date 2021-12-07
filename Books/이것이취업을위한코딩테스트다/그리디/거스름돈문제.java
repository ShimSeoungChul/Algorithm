import java.util.Scanner;

// https://scshim.tistory.com/224
public class 거스름돈문제 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int money = sc.nextInt(); // 거슬러 줘야할 돈

        int num = 0; // 필요한 동전 개수
        while (num != 0){
            if(money%500 == 0){
                money = money/500;
                num ++;
            }else if(money%100 == 0){
                money = money/100;
                num ++;
            }else if(money%50 == 0){
                money = money/50;
                num ++;
            }else if(money%10 == 0){
                money = money/10;
                num ++;
            }
        }

        System.out.println("필요한 동전의 개수: " + num);
    }
}
