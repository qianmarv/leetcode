class Solution{
    public int rob(int[] nums){
        if(nums == null || nums.length == 0) return 0;
        if(nums.length == 1) return nums[0];
        return Math.max(nums[0]+rob(2, nums.length-2, nums), rob(1, nums.length-1, nums));
    }
    // The solution without cycling
    private int rob(int start, int end, int[] nums){
        if(start > end) return 0;
        int prev2 = 0;
        int prev1 = nums[start++];
        int result = prev1;
        for(int i = start; i <= end; i++){
           result = Math.max(prev2+nums[i], prev1);
           prev2  = prev1;
           prev1  = result;
        }
        return result;
    }
}
