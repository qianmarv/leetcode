class Solution {
    //Runtime: 1 ms, faster than 61.78%
    //Memory Usage: 39.1 MB, less than 12.66%
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> ret = new ArrayList<>();
        for(int i = 0; i <= nums.length; i++){
            backtrack(nums, i, ret, new List<Integer>(), 0);
        }
        return ret;
    }

    private void backtrack(int[] nums, int k, List<List<Integer>> ret, List<Integer> prefix, int start){
        if(prefix.size() == k){
            ret.add(new ArrayList<>(prefix));
            return;
        }
        for(int i = start; i < nums.length; i++){
            prefix.add(nums[i]);
            backtrack(nums, k, ret, prefix, i+1);
            prefix.remove(prefix.size()-1);
        }
    }
}
