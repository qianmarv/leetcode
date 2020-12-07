class Solution {
    //Runtime: 0 ms, faster than 100.00%
    //Memory Usage: 39 MB, less than 93.25%
    public int maxSubArray(int[] nums) {
        int max = Integer.MIN_VALUE;
        int sum = nums[0];

        for(int i = 1; i < nums.length; i++){
            max = Math.max(max, sum);
            if(sum > 0){
                sum += nums[i];
            }else{
                sum = nums[i];
            }
        }
        return Math.max(max,sum);
    }

    public static void main(String[] args) {
        Solution so = new Solution();
        // int[] nums = new int[]{1,-1,1};
        int[] nums = new int[]{-2,1,-3,4,-1,2,1,-5,4};
        System.out.printf("Largest Sum = %d\n", so.maxSubArray(nums));
    }
}
