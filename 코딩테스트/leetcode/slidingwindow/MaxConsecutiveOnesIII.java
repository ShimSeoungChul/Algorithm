package leetcode.slidingwindow;

// https://leetcode.com/problems/maximum-number-of-vowels-in-a-substring-of-given-length/description/?envType=study-plan-v2&envId=leetcode-75

public class MaxConsecutiveOnesIII {
    void main() {
        assert longestOnes(new int[]{1, 1, 1, 0, 0, 0, 1, 1, 1, 1, 0}, 2) == 6 : "Test case 1 failed";
        assert longestOnes(new int[]{0,0,1,1,0,0,1,1,1,0,1,1,0,0,0,1,1,1,1}, 3) == 10 : "Test case 2 failed";
    }

    public int longestOnes(int[] nums, int k) {
        int left = 0;
        int length = nums.length;

        int result = 0;
        int zero_count = 0;
        for (int i = 0; i < length; i++) {
            if (nums[i] == 0) {
                zero_count++;
            }

            while (zero_count > k) {
                if(nums[left] == 0) {
                    zero_count--;
                }
                left++;
            }
            result = Math.max(result, i - left + 1);
        }
        return result;
    }
}
