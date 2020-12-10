/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    private int      maxCount  = 0;
    private int      curCount  = 0;
    private TreeNode prevNode  = null;
    //Runtime: 2 ms, faster than 62.86%
    //Memory Usage: 39.8 MB, less than 58.97%
    public int[] findMode(TreeNode root) {
        List<Integer> ret = new ArrayList<>();
        inOrder(root, ret);

        return ret.stream().mapToInt(Integer::valueOf).toArray();
    }
    private void inOrder(TreeNode root, List<Integer> ret){
        if(root == null) return;

        inOrder(root.left, ret);

        if(prevNode == null || prevNode.val != root.val){
            curCount = 1;
        }else{
            curCount++;
        }
        if(curCount > maxCount){
            maxCount = curCount;
            ret.clear();
            ret.add(root.val);
        }else if(curCount == maxCount){
            ret.add(root.val);
        }

        prevNode = root;
        inOrder(root.right, ret);
    }
}
