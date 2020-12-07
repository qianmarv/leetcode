class Solution {
    //Runtime: 0 ms, faster than 100.00%
    //Memory Usage: 39.4 MB, less than 81.91%
    public int singleNonDuplicate(int[] nums) {
        if(nums.length == 1) return nums[0];
        // 原始数组长度+1 / 2 如果为奇数，那么从中间切分之后，如果重复数字出现在左边，说明左边缺
        // 如果为偶数，则相反
        int lo = 0;
        int hi = nums.length - 1;

        while(lo <= hi){
            int mi = lo + (hi - lo) / 2;
            if(mi == 0 || mi == nums.length - 1 ||
               (nums[mi] != nums[mi+1] && nums[mi] != nums[mi-1])){
                return nums[mi];
            }else if(nums[mi] == nums[mi-1]){
                if(isEven(lo, hi)){
                    lo = mi + 1;
                }else{
                    hi = mi;
                };
            }else{
                if(isEven(lo, hi)){
                    hi = mi - 1;
                }else{
                    lo = mi;
                };
            }
        }
        return -1;
    }
    private boolean isEven(int lo, int hi){
        return ((hi - lo + 2) / 2) % 2 == 0;
    }
    public int singleNonDuplicateBetter(int[] nums) {
        int l = 0, h = nums.length - 1;
        while (l < h) {
            int m = l + (h - l) / 2;
            if (m % 2 == 1) {
                m--;   // 保证 l/h/m 都在偶数位，使得查找区间大小一直都是奇数
            }
            if (nums[m] == nums[m + 1]) {
                l = m + 2;
            } else {
                h = m;
            }
        }
        return nums[l];
    }
}
