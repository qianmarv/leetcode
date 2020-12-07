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
    //Runtime: 683 ms, faster than 19.09%
    //Memory Usage: 38.6 MB, less than 7.95%
    public int rob(TreeNode root) {
        if(root == null) return 0;
        int withRoot = root.val, withoutRoot = 0;
        if(root.left != null)  withRoot += rob(root.left.left) + rob(root.left.right);
        if(root.right != null) withRoot += rob(root.right.left) + rob(root.right.right);
        withoutRoot = rob(root.left) + rob(root.right);
        return Math.max(withRoot, withoutRoot);
    }
}
