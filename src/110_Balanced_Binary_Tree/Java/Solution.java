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
    private boolean isBalanced = true;
    //Runtime: 0 ms, faster than 100.00%
    //Memory Usage: 39.4 MB, less than 12.89%
    public boolean isBalanced(TreeNode root) {
        maxHeight(root);
        return isBalanced;
    }
    private int maxHeight(TreeNode root){
        if(root == null) return 0;
        int leftH  = maxHeight(root.left);
        int rightH = maxHeight(root.right);
        if(Math.abs(leftH - rightH) > 1) isBalanced = false;
        return 1 + Math.max(leftH, rightH);
    }
}
