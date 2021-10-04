public class BinaryDemo {
    public static void main(String args[]){
        int[] intArr = new int[] {0,2,4,6,8,10,12,14,16,18,20};
        int target = 4;
        int start = 0;
        int end = intArr.length;
        int result = -1;
        //4 찾기
        while(start <= end){
            int mid = (start  + end) / 2;
            if(target == intArr[mid]){
                result = mid;
                break;
            }else if(target < intArr[mid]){
                end = mid - 1;
            }else{
                start = mid + 1;
            }
        }

        System.out.println("target index:"+ result);
    }
}
