class Solution {
    //Runtime: 0 ms, faster than 100.00%
    //Memory Usage: 40.3 MB, less than 92.86%
    public boolean checkPossibility(int[] nums) {
        int dCnt = 0;
        for(int i = 1; i < nums.length; i++){
            if(nums[i] > nums[i-1]){
                dCnt++;
                if(dCnt > 1) return false;
                if(i==1 || nums[i-2] <= nums[i]){
                    nums[i-1] = nums[i];
                }else{
                    nums[i] = nums[i-1];
                }
            }
        }
        return dCnt <= 1;
    }
}
