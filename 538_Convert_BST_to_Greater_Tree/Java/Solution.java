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
    //Memory Usage: 39.7 MB, less than 20.51%
    private int sum = 0;
    public TreeNode convertBST(TreeNode root) {
        //Inorder from right to left, stack-> record each number
        Inorder(root);
        return root;
    }
    private void Inorder(TreeNode root){
        if(root == null) return;
        Inorder(root.right);
        root.val += sum;
        sum = root.val;
        Inorder(root.left);
    }
}
