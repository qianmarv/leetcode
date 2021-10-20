using  System.Collection.Generic;

public class Solution {
    public int[] TwoSum(int[] nums, int target) {
        var dict = new Dictionary<int, int>();

        for(int i = 0; i < nums.Length; i++)
        {
            int num = target - nums[i];
            if(dict.ContainsKey(num)){
                int j = dict[num];
                return new int[]{j,i};
            }
            if(!dict.ContainsKey(nums[i]))
            {
                dict.Add(nums[i], i);
            }

        }
        return new int[]{-1,-1};
    } 
}
