import java.util.*;

class Solution {
        //Runtime: 1 ms, faster than 91.95%
    //Memory Usage: 39.1 MB, less than 17.28%
    public List<List<Integer>> permute(int[] nums) {
        boolean[] visited = new boolean[nums.length];
        List<Integer> prefix = new ArrayList<>();
        List<List<Integer>> ret = new ArrayList<>();
        permute(nums, ret, prefix, visited);
        return ret;
    }

    private void permute(int[] nums, List<List<Integer>> ret,List<Integer> prefix, boolean[] visited){
        for(int i = 0; i < nums.length; i++){
            if(visited[i]) continue;
            int curr = prefix.size();
            List<Integer> per = new ArrayList<>(prefix);
            per.add(nums[i]);
            if(curr + 1 == nums.length){
                ret.add(per);
            }
            visited[i] = true;
            permute(nums, ret, per, visited);
            visited[i] = false;
        }
    }

    public static void main(String[] args) {
        Solution so = new Solution();
        final int[] nums = new int[]{1,2,3};
        List<List<Integer>> permutes = so.permute(nums);
        for(List<Integer> p: permutes){
            System.out.println(p.toString());
        }
    }
}
