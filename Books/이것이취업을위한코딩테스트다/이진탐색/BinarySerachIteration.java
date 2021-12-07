import java.math.BigDecimal;
import java.util.Arrays;

public class BinarySerachIteration {
    public static void main(String[] args){
        int[] arr = {0,2,4,6,8,10,12,14,16,18};
        int target = 4;
        BinarySerachIteration binarySerach = new BinarySerachIteration();
        int result = binarySerach.binarySearch(arr, target, 0, arr.length);

        if(result == -1) System.out.println("탐색하는 값이 존재하지 않습니다.");
        else System.out.println(target+"의 위치:"+result);
    }

    int binarySearch(int[] arr, int target, int start ,int end){

        while (start<=end){
            int mid = (start+end)/2;
            if (target == arr[mid]) return mid;
            else if(target < arr[mid]) end = mid-1;
            else start = mid+1;
        }
        return -1;
    }
}
