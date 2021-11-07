import java.util.Scanner;

// TODO: 다시 풀기
public class 시각 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        int count = 0;
        for(int i=0; i <= num; i++){
            for(int j=0; j <= 59; j++){
                for(int k=0; k <= 59; k++){
                    String hour = Integer.toString(i);
                    String minute = Integer.toString(j);
                    String second = Integer.toString(k);

                    if(hour.contains("3") || minute.contains("3") || second.contains("3")){
                        count++;
                    }
                }
            }
        }

        System.out.println(count);
    }
}
