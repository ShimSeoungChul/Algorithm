package leetcode.twopointers;

import java.util.*;

public class MoveZeros {
    void main() {
        assert Arrays.equals(
                moveZeroes(new int[] {0,1,0,3,12}),
                new int[] {1,3,12,0,0}
        ) : "Test1 Failed";
        assert Arrays.equals(
                moveZeroes(new int[] {0}),
                new int[] {0}
        ) : "Test2 Failed";
    }

    public int[] moveZeroes(int[] nums) {
        int index = 0; // 값을 채울 위치

        for (int num: nums) {
            if(num != 0) {
                nums[index++] = num;
            }
        }

        while (index < nums.length) {
            nums[index++] = 0;
        }

        return nums;
    }
}
