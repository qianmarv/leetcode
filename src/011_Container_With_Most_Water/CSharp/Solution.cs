public class Solution {
    public int MaxArea(int[] height) {
        int i = 0, j = height.Length - 1;
        int max = 0;
        while(i<j){
            if(height[i] < height[j]){
                max= Math.Max(max, height[i] * (j-i));
                i++;
            }else if(height[i] > height[j]){
                max= Math.Max(max, height[j] * (j-i));
                j--;
            }else{
                max= Math.Max(max, height[i]*(j-i));
                i++;
                j--;
            }
        }
        return max;
    }
}
