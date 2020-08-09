class Solution {
    // Runtime: 4 ms, faster than 38.59% of Java online submissions for Median of Two Sorted Arrays.
    // Memory Usage: 46 MB, less than 38.63% of Java online submissions for Median of Two Sorted Arrays.
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        // Swap nums to make sure nums1.length < nums2.length
        if(nums1.length > nums2.length){
            int[] temp = nums1;
            nums1 = nums2;
            nums2 = temp;
        }

        double result = 0;
        int i = 0, j = 0;
        int m, n;
        boolean isEven;

        m = nums1.length;
        n = nums2.length;

        isEven = (m+n)%2 == 0;

        int i_left,i_right, j_left, j_right;
        int max_left, min_right;
        for(;i<m+1;i++){
            //Boundary of i = m, j = n!
            j = (m+n+1)/2 - i;
            if(m == 0){ // First Array is empty
                if(j == 0){ // Second Array is empty
                    result = 0;
                }else if(j == n){ // Second Array contains only one element
                    result  = nums2[j-1];
                }else{
                    result = isEven ? (nums2[j-1] + nums2[j])/2.0 : nums2[j-1] ;
                }
                break;
            }
            // Compare digits
            if(i == 0){
                max_left = nums2[j-1];
            }else if( j == 0){
                max_left = nums1[i-1];
            }else{
                max_left = Math.max(nums1[i-1], nums2[j-1]);
            }

            if(i == m){
                min_right = nums2[j];
            }else if( j == n){
                min_right = nums1[i];
            }else{
                min_right = Math.min(nums1[i], nums2[j]);
            }

            if(max_left <= min_right){ // find the position
                if(isEven){
                    result = (max_left + min_right) / 2.0;
                }else{
                    result = max_left;
                }
            }
        }
        return result;
    }

    public static void main(String[] args){
        Solution sol = new Solution();
        int[] n1 = new int[]{1,2};
        int[] n2 = new int[]{3,4};
        System.out.println(sol.findMedianSortedArrays(n1,n2));
    }
}
