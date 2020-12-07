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
    //Runtime: 2 ms, faster than 97.55%
    //Memory Usage: 41.9 MB, less than 9.32%
    private int maxPath = 0;
    public int longestUnivaluePath(TreeNode root) {
        dfs(root);
        return maxPath;
    }
    private int dfs(TreeNode root){
        if(root == null) return 0;
        int l = dfs(root.left);
        int r = dfs(root.right);
        if(root.left != null && root.val == root.left.val) l++;
        else l = 0;

        if(root.right != null && root.val == root.right.val) r++;
        else r = 0;

        maxPath = Math.max(maxPath, l+r);
        return Math.max(l, r);
    }
}
