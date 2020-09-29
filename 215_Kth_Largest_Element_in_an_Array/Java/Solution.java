import java.util.Arrays;

class Solution {
    //Runtime: 8 ms, faster than 31.64%
    //Memory Usage: 39.1 MB, less than 99.67%
    //Runtime: 1 ms, faster than 98.45% - With introduce the random
    //Memory Usage: 39.5 MB, less than 89.77%
    public int findKthLargest(int[] nums, int k) {
        int lo = 0;
        int hi = nums.length - 1;
        k = nums.length - k;
        while(true){
            int j = partition(nums, lo, hi);
            if(j < k)
                lo = j + 1;
            else if(j > k){
                hi = j - 1;
            }else{
                return nums[j];
            }
        }

    }
    private void swap(int[] nums, int i, int j){
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
    private int partition(int [] nums, int lo, int hi){
        int i = lo;
        int j = hi + 1;
        int random = new Random().nextInt(hi-lo+1) + lo;
        swap(nums, random, lo);
        int num = nums[lo];
        while(true){
            while(nums[++i] <= num && i < hi) continue;
            while(nums[--j] >= num && j > lo) continue;
            if(i >= j) break;
            swap(nums, i, j);
        }
        swap(nums, lo, j);
        return j;
    }

    public static void main(String[] args) {
        Solution so = new Solution();
        int[] nums = new int[]{3,2,3,1,2,4,5,5,6};
        so.findKthLargest(nums, 4);
    }
}
