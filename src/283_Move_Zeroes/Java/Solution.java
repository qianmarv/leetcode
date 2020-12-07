class Solution {
    //Runtime: 0 ms, faster than 100.00%
    //Memory Usage: 39.5 MB, less than 37.13%
    public void moveZeroes(int[] nums) {
        int zeroHead = 0, zeroTail = 0;
        //First time scan, find leading zero
        while(zeroHead < nums.length && nums[zeroHead] !=0 ) zeroHead++;
        if(zeroHead == nums.length) return;
        zeroTail = zeroHead;

        while(++zeroTail < nums.length){
            if(nums[zeroTail] == 0) continue;
            nums[zeroHead++] = nums[zeroTail];
            nums[zeroTail] = 0;
        }
    }
}
