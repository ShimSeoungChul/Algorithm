
import java.util.*;
import java.util.List;

/*
4 6
19 15 10 17
 */
public class Hard_떡볶이떡만들기 {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        int N,M; //떡의 개수, 요청한 떡의 길이
        N = scanner.nextInt();
        M = scanner.nextInt();

        List<Integer> lengthList = new ArrayList<>(); // 떡들의 길이
        for(int i=0; i <N ; i++) {
            Integer num = scanner.nextInt();
            lengthList.add(num);
        }

        lengthList.sort(Comparator.naturalOrder());
        int end = lengthList.get(lengthList.size()-1);
        int start = 0;
        binarySearch(start,end,M,lengthList);
    }

    static void binarySearch(int start , int end, int target, List<Integer> lengthList){
        while(start <= end){
            int mid = (start+end)/2; // 절단기 길이 구하기
            // 자르고 남은 떡의 길이
            int remainder = lengthList.stream()
                    .filter(length -> length>mid) //절단기 보다 짧은 떡을 제거하고,
                    .mapToInt(x->x%mid) //절단기로 자른 떡들의 길이를 매핑하여,
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
