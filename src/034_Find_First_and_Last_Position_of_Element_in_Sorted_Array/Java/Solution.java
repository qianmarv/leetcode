class Solution {
    //Runtime: 0 ms, faster than 100.00%
    //Memory Usage: 42.5 MB, less than 75.61%
    public int[] searchRange(int[] nums, int target) {
        int first = findFirst(nums, target);
        int last  = findFirst(nums, target+1) - 1;
        if(first == nums.length || nums[first] != target){
            return new int[]{-1,-1};
        }else{
            return new int[]{first, Math.max(first, last)};
        }
    }
    
    private int findFirst(int[] nums, int target){
        int lo = 0, hi = nums.length;
        while(lo < hi){
            int mi = lo + (hi - lo)/2;
            if(nums[mi] >= target){
                hi = mi;
            }else{ // less than
                lo = mi + 1;
            }
        }
        return lo;
    }
}
