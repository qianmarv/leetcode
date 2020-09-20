class Solution{
    //Brute Force Solution with O(n*n)
    //Runtime: 336 ms, faster than 19.31%
    //Memory Usage: 39.9 MB, less than 52.40%
    public int maxArea_1(int[] height) {
        // a fast O(n2)
        int result = 0;
        for(int i  = 0; i < height.length-1; i++){
            for(int j = i+1; j < height.length;j++){
                int w = j - i;
                int h = Math.min(height[i], height[j]);
                result = Math.max(result, w*h);
            }
        }
        return result;
    }
    //Two Pointers
    //Runtime: 2 ms, faster than 96.32%
    //Memory Usage: 39.7 MB, less than 80.41%
    public int maxArea_2(int[] height){
        int result = 0;
        int l = 0;
        int r = height.length-1;
        while(l<r){
            int w = r - l;
            int h;
            if(height[l] <= height[r]){
                h = height[l++];
            }else{
                h = height[r--];
            }
            result = Math.max(result, w*h);
        }
        return result;
    }
    public static void main(String[] args){
        Solution so = new Solution();
        var test = new int[]{1,8,6,2,5,4,8,3,7};
        System.out.printf("Solution 1 - The Max Is: %d", so.maxArea_1(test));
        System.out.printf("Solution 2 - The Max Is: %d", so.maxArea_2(test));
    }
}
