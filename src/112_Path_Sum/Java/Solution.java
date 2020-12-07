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
    //Memory Usage: 38.8 MB, less than 12.89%
    public boolean hasPathSum(TreeNode root, int sum) {
        if(root == null) return false;
        else if(root.left == null && root.right == null){
            return root.val == sum;
        }
        return ( root.left != null && hasPathSum(root.left, sum - root.val) )||
               ( root.right != null && hasPathSum(root.right, sum - root.val) );
    }
}
