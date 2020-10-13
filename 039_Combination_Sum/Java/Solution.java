import java.util.*;
class Solution {
    //Runtime: 2 ms, faster than 99.26%
    //Memory Usage: 39.2 MB, less than 5.46%
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> ret = new ArrayList<>();
        List<Integer> prefix    = new ArrayList<>();
        backtrack(candidates, target, ret, prefix, 0);
        return ret;
    }

    private void backtrack(int[] candidates, int target, List<List<Integer>>ret, List<Integer> prefix, int start){
        if(target == 0){
            List<Integer> curr = new ArrayList<>(prefix);
            ret.add(curr);
            return;
        }

        for(int i = start; i < candidates.length; i++){
            int num = candidates[i];
            if(num <= target){
                prefix.add(num);
                backtrack(candidates, target-num, ret, prefix, i);
                prefix.remove(prefix.size()-1);
            }
        }
    }
}

class SolutionRecursive {
    //Runtime: 2 ms, faster than 99.26%
    //Memory Usage: 38.9 MB, less than 5.46%
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> ret = new ArrayList<>();
        List<Integer> prefix    = new ArrayList<>();
        backtrack(candidates, target, ret, prefix, 0);
        return ret;
    }

    private void backtrack(int[] candidates, int target,List<List<Integer>> ret, List<Integer> prefix, int start){
        if(target == 0){
            List<Integer> curr = new ArrayList<>(prefix);
            ret.add(curr);
            return;
        }else if(start > candidates.length - 1){
            return;
        }

        int num = candidates[start];
        if(num <= target){
            prefix.add(num]);
            backtrack(candidates, target-num, ret, prefix, start);
            prefix.remove(prefix.size()-1);
        }
        backtrack(candidates, target, ret, prefix, start+1);
    }
}
