import java.util.Arrays;
import java.util.Scanner;

/*
5
8 3 7 9 2
3
5 7 9
 */
public class 부품찾기 {
    public static void main(String [] args){
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        int[] parts = new int[N];
        for(int i=0; i<N; i++) parts[i] = scanner.nextInt();

        int M = scanner.nextInt();
        int[] selectedParts = new int[M];
        for(int i=0; i<M; i++) selectedParts[i] = scanner.nextInt();

        부품찾기 bs = new 부품찾기();
        bs.binarySearch(parts, selectedParts);
    }

    public void binarySearch(int[] parts, int[] selectParts){
        //탐색을 원하는 부품 반복
        Arrays.stream(selectParts)
                .forEach(x-> {
                    int target = x;
                    int start = 0;
                    int end = selectParts.length;
                    boolean isYes = false;

                    //이진 탐색으로 부품 존재 확인
                    while(start <= end){
                        int mid = (start + end) / 2;
                        if(target == selectParts[mid]){
                            System.out.print("yes ");
                            isYes = true;
                            break;
                        }else if(target < parts[mid]){
                            end = mid - 1;
                        }else{
                            start = mid + 1;
                        }
                    }
                    if(!isYes) System.out.print("no ");
                });
    }
}
