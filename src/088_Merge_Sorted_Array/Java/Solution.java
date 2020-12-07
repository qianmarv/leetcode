class Solution {
    // Runtime: 0 ms, faster than 100.00%
    // Memory Usage: 39.4 MB, less than 82.24%
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int i = m-1;  // point to head of nums1
        int j = n-1;  // point to head of nums2
        int k = m+n-1;  // point to tail of nums1

        while(k >= 0){
            if(j < 0 || ( i >= 0 && nums1[i] > nums2[j])){
                nums1[k--] = nums1[i--];
            }else{
                nums1[k--] = nums2[j--];
            }
        }
    }
}
