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
    //Memory Usage: 38.9 MB, less than 52.26%
    private int min = Integer.MAX_VALUE;
    public int getMinimumDifference(TreeNode root) {
        inorder(root, 0);
        return min;
    }

    private int inorder(TreeNode root, int prev){
        if(root == null) return prev;
        prev = inorder(root.left, prev);
        if(prev != -1) {
            min = Math.min(min, Math.abs(root.val - prev));
        }
        return inorder(root.right, root.val);
    }
}
