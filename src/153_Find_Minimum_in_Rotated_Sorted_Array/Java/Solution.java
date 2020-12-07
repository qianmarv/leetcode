class Solution {
    //Runtime: 0 ms, faster than 100.00%
    //Memory Usage: 38.3 MB, less than 96.02%
    public int findMin(int[] nums) {
        if(nums.length == 1) return nums[0];

        int lo = 0;
        int hi = nums.length - 1;

        while(lo < hi){
            int mi = lo + (hi - lo)/2;
            if(nums[mi] <= nums[hi]){
                hi = mi;
            }else{
                lo = mi + 1;
            }
        }
        return nums[lo];
    }
}
