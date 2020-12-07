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
    //Runtime: 0 ms, faster than 100.00%
    //Memory Usage: 36.7 MB, less than 9.49%
    public int sumOfLeftLeaves(TreeNode root) {
        if(root == null) return 0;
        TreeNode l = root.left;
        TreeNode r = root.right;
        int ret = 0;
        if(l != null){
            if(l.left == null && l.right == null) ret += l.val;
            else{
                ret += sumOfLeftLeaves(l);
            }
        }
        ret += sumOfLeftLeaves(r);
        return ret;
    }
}
