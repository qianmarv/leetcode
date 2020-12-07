class Solution {
    //Runtime: 1 ms, faster than 99.75%
    //Memory Usage: 38.9 MB, less than 7.47%
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> ret = new ArrayList<Integer>();
        List<Integer> prefix    = new ArrayList<Integer>();
        for(int k = 0; k <= nums.length; k++){
            backtracking(nums, k, ret, prefix, 0);
        }
        return ret;
    }
    private void backtracking(int[] nums, int k, List<List<Integer>> ret, List<Integer> prefix, int start){
        if(prefix.size() == k){
            ret.add(new ArrayList<Integer>(prefix));
        }
        for(int i = start; i < nums.length; i++){
            //TODO try to exit ealier according to k ? nums.length - i
            if(i > start && nums[i] == nums[i-1]) continue;
            prefix.add(nums[i]);
            backtracking(nums, k, ret, prefix, i+1);
            prefix.remove(prefix.size()-1);
        }
    }
}
