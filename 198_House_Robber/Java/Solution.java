class Solution{
    public int rob(int[] nums){
        if(nums == null || nums.length == 0 ) return 0;
        if(nums.length == 1) return nums[0];
        int len = nums.length;

        int maxPrev2 = 0;
        int maxPrev1 = nums[0];
        int result   = 0;
        // 0,[3],[5],[3]
        for(int i = 1; i < nums.length; i++){
           result = Math.max(maxPrev2+nums[i], maxPrev1);
           maxPrev2 = maxPrev1;
           maxPrev1 = result;
        }
        return result;
    }
}
