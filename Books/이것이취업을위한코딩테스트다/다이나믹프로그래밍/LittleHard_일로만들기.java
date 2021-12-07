import java.util.Map;
import java.util.Scanner;
import java.util.stream.IntStream;

public class LittleHard_일로만들기 {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        int target = scanner.nextInt();

        int [] resultArr = new int[target+1];
        resultArr[1] = 0;

        IntStream.rangeClosed(2,target)
                .forEach(x->{
                    //현재 식에 1을 뺴는 경우
                    resultArr[x] = resultArr[x-1]+1;
                    //현재 식에 5를 나누는 경우
                    if(x%5 == 0)
                        resultArr[x] = Math.min(resultArr[x], resultArr[x/5]+1);
                    //현재 식에 3를 나누는 경우
                    if(x%3 == 0)
                        resultArr[x] = Math.min(resultArr[x], resultArr[x/3]+1);
                    //현재 식에 2를 나누는 경우
                    if(x%2 == 0)
                        resultArr[x] = Math.min(resultArr[x], resultArr[x/2]+1);
                });
        System.out.println(resultArr[target]);
    }
}
