public class BinarySerachRecursion {
    public static void main(String[] args){
        int[] arr = {0,2,4,6,8,10,12,14,16,18};
        int target = 4;
        BinarySerachRecursion binarySerach = new BinarySerachRecursion();
        int result = binarySerach.binarySearch(arr, target, 0, arr.length);

        if(result == -1) System.out.println("탐색하는 값이 존재하지 않습니다.");
        else System.out.println(target+"의 위치:"+result);
    }

    int binarySearch(int[] arr, int target, int start , int end){
        if(start>end) return -1;

        int mid = (start+end)/2;
        //찾은 경우 중간점 위치 반환
        if (arr[mid] == target) return mid;
        //중간점 값보다 찾는 값이 작은 경우 왼쪽 확인
        else if(arr[mid] > target) return binarySearch(arr,target,start,mid-1);
        //중간점 값보다 찾는 값이 큰 경우 오른쪽 확인
        else return binarySearch(arr,target,mid+1,end);
    }
}