import java.util.Scanner;

/*
5
R R R U D D
 */
public class 상하좌우 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt(); // 1 <= 공간의 크기 <= 100
        int row = 1; // 모험자의 행 위치
        int col = 1; // 모험자의 열 위치

        sc.nextLine();

        String planString = sc.nextLine();
        String[] plans = planString.split(" ");

        for(String plan: plans){
            if(plan.equals("R")){
                if(!(col+1 > N)){
                    col++;
                }
            }else if(plan.equals("L")){
                if(!(col-1 < 1)){
                    col--;
                }
            }else if(plan.equals("U")){
                if(!(row-1 < 1)){
                    row--;
                }
            }else if(plan.equals("D")){
                if(!(row+1 > N)){
                    row++;
                }
            }
        }

        System.out.println(row + " " + col);
    }
}
