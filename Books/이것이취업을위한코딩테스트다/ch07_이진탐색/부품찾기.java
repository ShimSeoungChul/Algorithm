import java.util.Arrays;
import java.util.Scanner;

import java.util.Scanner;
import java.util.StringJoiner;
import java.util.stream.IntStream;

/*
입력 예시
5
8 3 7 9 2
3
5 7 9
 */
public class 부품찾기 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] parts = IntStream.range(0,N)
            .map(num -> sc.nextInt()) // 입력
            .sorted() // 정렬
            .toArray();

        int M = sc.nextInt();
        int[] requests =  IntStream.range(0,M)
            .map(num -> sc.nextInt()) // 입력
            .toArray();

        StringJoiner result = new StringJoiner(" ");
        for(int target: requests){
            String check = binarySearch(parts, target, 0, parts.length-1);
            result.add(check);
        }

        System.out.println(result);
    }

    static String binarySearch(final int[] arr, final int target, int start, int end){
        while(start <= end){
            final int mid = (start + end)/2;
            if(arr[mid] == target){
                return "yes";
            }else if(arr[mid] < target){
                start = mid + 1;
            }else{
                end = mid - 1;
            }
        }
        
        return "no";
    }
}
