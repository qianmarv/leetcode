import java.util.*;
class Solution {
    //Runtime: 11 ms, faster than 58.86%
    //Memory Usage: 37.4 MB, less than 5.00%
    public int lengthOfLIS(int[] nums) {
        if(nums.length < 2) return nums.length;
        int[] dp = new int[nums.length];
        dp[0] = 1;
        for(int i = 1; i < nums.length; i++){
            int max = 1;
            for(int j = 0; j < i; j++){
                if(nums[i] > nums[j]){
                    max = Math.max(max, dp[j]+1);
                }
                dp[i] = max;
            }
        }
        int result = dp[0];
        for(int i = 1; i < nums.length; i++){
            result = Math.max(result, dp[i]);
        }
        return result;
    }
    //Runtime: 0 ms, faster than 100.00%
    //Memory Usage: 37.2 MB, less than 5.00%
    public int lengthOfLIS2(int[] nums){
        int[] tail = new int[nums.length];
        int len = 0;
        for(int i = 0; i < nums.length; i++){
            int index = binarySearch(tail, len, nums[i]);
            tail[index] = nums[i];
            if(index == len){
                len++;
            }
        }
        return len;
    }

    private int binarySearch(int[] tail, int len, int key){
        int lo = 0, hi = len;
        System.out.println("tail: " + Arrays.toString(tail));
        while(lo < hi){
            int mi = lo + (hi - lo) / 2;
            if(tail[mi] == key) return mi;
            else if(tail[mi] > key) hi = mi;
            else lo = mi + 1;
        }
        System.out.printf("Key:%d, Len:%d, Index:%d\n", key, len, lo);
        return lo;
    }

    public static void main(String[] args) {
        Solution so = new Solution();
        int[] nums = new int[]{10,9,2,5,3,4};
        so.lengthOfLIS2(nums);
    }
}
