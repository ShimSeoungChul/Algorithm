
import java.util.*;
import java.util.List;
import java.util.stream.IntStream;

/*
4 6
19 15 10 17
 */
public class 떡볶이떡만들기 {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        int N,M; //떡의 개수, 요청한 떡의 길이
        N = scanner.nextInt();
        M = scanner.nextInt();

        // 떡 길이 입력
        int[] lengthArr = IntStream.range(0,N)
            .map(i -> scanner.nextInt())
            .sorted() // 이진 탐색 사용을 위해 정렬
            .toArray();

        int start = 0;
        int end = lengthArr[lengthArr.length-1];
        binarySearch(start,end,M,lengthArr);
    }

    static void binarySearch(int start , int end, int target, int[] lengthArr){
        while(start <= end){
            int mid = (start+end)/2; // 절단기 길이 구하기
            // 자르고 남은 떡의 길이
            int remainder = Arrays.stream(lengthArr)
                    .filter(length -> length>mid) //절단기 보다 짧은 떡을 제거하고,
                    .map(x->x%mid) //절단기로 자른 떡들의 길이를 매핑하여,
                    .sum(); //더한다.

            if(remainder == target) {
                System.out.println(mid);
                break;
            }else if(remainder > target){
                start = mid+1;
            } else {
                end = mid-1;
            }
        }
    }
}
