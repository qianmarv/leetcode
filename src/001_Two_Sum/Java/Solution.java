class Solution {
    public int[] twoSum(int[] nums, int target){
        Map<Integer, Integer> map = new HashMap<>();
        int[] result = new int[2];

        for(int i = 0; i < nums.length; i++) {
            int second = target - nums[i];
            if(map.containsKey(second)){
                int j = map.get(second);
                result[0] = j;
                result[1] = i;
                return result;
            }else{
                map.put(nums[i], i);
            }
        }
        return result;
    }
}
