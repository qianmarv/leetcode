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
    private int count;
    private int value;
    //Runtime: 0 ms, faster than 100.00%
    //Memory Usage: 38.7 MB, less than 75.15%
    public int kthSmallest(TreeNode root, int k) {
        this.count = k;
        inOrder(root);
        return this.value;
    }
    private void inOrder(TreeNode root){
        if(root == null) return;
        inOrder(root.left);
        if(--count == 0){
            this.value = root.val;
            return;
        }
        inOrder(root.right);
    }
}
