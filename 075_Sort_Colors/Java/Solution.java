import java.util.Arrays;
class Solution {
    //Runtime: 0 ms, faster than 100.00%
    //Memory Usage: 38.8 MB, less than 21.39%
    public void sortColors(int[] nums){
        int lo = 0;
        int hi = nums.length - 1;
        int i  = 0;
        while(i <= hi){
            if(nums[i] < 1){
                swap(nums, lo++, i++);
            }else if(nums[i] > 1){
                swap(nums, i, hi--);
            }else{
                i++;
            }
            // System.out.println(Arrays.toString(nums));
        }
    }
    private void swap(int[] nums, int i, int j){
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }

    public static void main(String[] args) {
        Solution so = new Solution();
        int[] nums  = new int[]{2};
        so.sortColors(nums);
        System.out.println(Arrays.toString(nums));
    }
}
