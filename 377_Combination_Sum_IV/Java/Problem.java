class Solution {
    //Runtime: 1 ms, faster than 82.53%
    //Memory Usage: 35.9 MB, less than 6.70%
    public int combinationSum4(int[] nums, int target) {
        int[] dp = new int[target+1];
        dp[0] = 1;
        for(int i = 1; i <= target; i++){
            for(int j = 0; j < nums.length; j++){
                if(nums[j] <= i){
                    dp[i] = dp[i] + dp[i-nums[j]];
                }
            }
        }
        return dp[target];
    }
}
