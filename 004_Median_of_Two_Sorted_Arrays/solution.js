/*
 * There are two sorted arrays nums1 and nums2 of size m and n respectively.

 Find the median of the two sorted arrays. The overall run time complexity should be O(log (m+n)).

 Example 1:
 nums1 = [1, 3]
 nums2 = [2]
 The median is 2.0.

 Example 2:
 nums1 = [1, 2]
 nums2 = [3, 4]
 The median is (2 + 3)/2 = 2.5
*/

module.exports = {
    // Relay on the embedded sort algorithms
    // Lazy and cunning
    findMedianSortedArrays1: function(nums1, nums2){

        let nums = nums1.concat(nums2);
        nums.sort(function(a,b){return a - b});
        console.log(nums);
        let len  = nums.length;
        if(len % 2 === 0){
            let n  = len / 2;
            return (nums[n-1] + nums[n])/2;
        }else{
            return nums[Math.floor(len / 2)];
        }
    },
    // dived into two parts, with same length
    findMedianSortedArrays2: function(nums1, nums2){
        //swap
        if(nums1.length > nums2.length){
            let tmp = nums2;
            nums2 = nums1;
            nums1 = tmp;
        }

        let m = nums1.length;
        let n = nums2.length;
        let iLeft  = 0;
        let iRight =  m-1;
        while(true){
            let i = Math.floor((iLeft + iRight)/2); // initial
            let j = Math.floor((m+n-i*2)/2)-1;
            console.log("i="+i+";j="+j);
            if(i === -1){
                return [nums2[j-1], nums2[j]];
            }else if( nums1[i] <= nums2[j+1] &&
                     (i === m - 1 || nums2[j] <= nums1[i+1])){//TODO Boundary i = m!!
                return [nums1[i],nums2[j]];
            }else if(nums1[i] > nums2[j+1]){//  Move to left
                iRight = i - 1;
            }else if(nums2[j] > nums1[i+1]){ // Move to Right
                iLeft = i + 1;
            }
        }
    }
}
