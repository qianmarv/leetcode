class Solution {
    //Runtime: 2 ms, faster than 58.07%
    //Memory Usage: 40 MB, less than 6.94%
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> ret = new ArrayList<>();
        List<Integer> prefix = new ArrayList<>();
        boolean[] visited = new boolean[nums.length];
        backtrack(nums, prefix, visited, ret);
        return ret;
    }

    private void backtrack(int[] nums, List<Integer> prefix, boolean[] visited, List<List<Integer>> permutes){
        Map<Integer, Boolean> currentVisited = new HashMap<>();
        for(int i = 0; i < nums.length; i++){
            int num = nums[i];
            if(visited[i] || currentVisited.get(num)){
                continue;
            }
            visited[i] = true;
            List<Integer> curr = new ArrayList<>(prefix);
            curr.add(num);

            if(curr.size() == nums.length){
                permutes.add(curr);
                return;
            }
            backtrack(nums, curr, visited, permutes);
            visited[i] = false;
            currentVisited.put(num, true);
        }
    }
}

class SolutionSort {
    //Runtime: 1 ms, faster than 99.35%
    //Memory Usage: 39.6 MB, less than 6.94%
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> ret = new ArrayList<>();
        List<Integer> prefix = new ArrayList<>();
        boolean[] visited = new boolean[nums.length];
        Arrays.sort(nums);
        backtrack(nums, prefix, visited, ret);
        return ret;
    }

    private void backtrack(int[] nums, List<Integer> prefix, boolean[] visited, List<List<Integer>> permutes){
        for(int i = 0; i < nums.length; i++){
            int num = nums[i];
            if(visited[i])  continue;
            if(i > 0 && num == nums[i-1] && !visited[i-1]) continue;
            visited[i] = true;
            List<Integer> curr = new ArrayList<>(prefix);
            curr.add(num);

            if(curr.size() == nums.length){
                permutes.add(curr);
            }else{
                backtrack(nums, curr, visited, permutes);
            }
            visited[i] = false;
        }
    }
}
