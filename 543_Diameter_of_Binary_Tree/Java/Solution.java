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
    private int max = 0;
    //Runtime: 0 ms, faster than 100.00%
    //Memory Usage: 38.8 MB, less than 11.79%
    public int diameterOfBinaryTree(TreeNode root) {
        maxHeight(root);
        return max;
    }
    private int maxHeight(TreeNode root){
        if(root == null) return 0;
        int l = maxHeight(root.left);
        int r = maxHeight(root.right);
        max = Math.max(max, l+r);
        return Math.max(l,r)+1;
    }
}
