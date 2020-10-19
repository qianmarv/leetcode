class Solution {
    //Traditional DP
    //Runtime: 6 ms, faster than 7.74%
    //Memory Usage: 36.2 MB, less than 14.23%
    public int wiggleMaxLength_1(int[] nums) {
        if(nums.length < 2 ) return nums.length;

        int[][] dp = new int[nums.length][2];
        dp[0][0] = 1;
        for(int i = 1; i < nums.length; i++){
            int len = 0;
            for(int j = 0; j < i; j++){
                if(dp[j][0] == 1 && nums[j] != nums[i]){
                    if(len < 1){
                        len = 2;
                    }
                }
                else if((nums[i] > nums[j] && nums[j] < dp[j][1]) ||
                        (nums[i] < nums[j] && nums[j] > dp[j][1])){
                    if((dp[j][0]+1) > len){
                        len = dp[j][0] + 1;
                    }
                }else{
                    continue;
                }
                dp[i][0] = len;
                dp[i][1] = nums[j];
            }
        }
        int ret = 0;
        for(int i = 0; i < dp.length; i++){
            ret = Math.max(ret, dp[i][0]);
        }

        return ret;
    }

    //Optimized DP
    //Runtime: 0 ms, faster than 100.00%
    //Memory Usage: 36.2 MB, less than 14.23%
    public int wiggleMaxLength_2(int[] nums){
        if(nums.length < 2) return nums.length;
        int down = 1, up = 1;
        for(int i = 1; i < nums.length; i++){
          if(nums[i] > nums[i-1]){
              up = down + 1;
          }else if(nums[i] < nums[i-1]){
              down = up + 1;
          }
        }
        return Math.max(down, up);
    }
}
