class Solution {
    //Runtime: 2 ms, faster than 98.51%
    //Memory Usage: 39.9 MB, less than 5.08%
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> ret = new ArrayList<>();
        List<Integer> prefix    = new ArrayList<>();
        Arrays.sort(candidates);
        backtracking(candidates, target, ret, prefix, 0);
        return ret;
    }

    private void backtracking(int [] candidates, int target, List<List<Integer>> ret, List<Integer> prefix, int start){
        if(target == 0){
            ret.add(new ArrayList<>(prefix));
        }
        for(int i = start; i < candidates.length; i++){
            int num = candidates[i];
            if(i > start && candidates[i-1] == num) continue;
            if(num <= target){
                prefix.add(num);
                backtracking(candidates, target - candidates[i], ret, prefix, i+1);
                prefix.remove(prefix.size()-1);
            }
        }
    }
}
