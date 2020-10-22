

class Solution {
    //Runtime: 274 ms, faster than 39.78%
    //Memory Usage: 36.5 MB, less than 5.70%
    public int findTargetSumWays(int[] nums, int S) {
        return dfs(nums, S, 0);
    }
    private int dfs(int[] nums, int sum, int start){
        if(start == nums.length - 1){
            if(nums[start] == 0 && sum == 0) return 2;
            else if(sum == nums[start] || sum == -1 * nums[start]) return 1;
            else return 0;
        }
        return dfs(nums, sum-nums[start], start+1) + dfs(nums, sum+nums[start], start+1);
    }
}
