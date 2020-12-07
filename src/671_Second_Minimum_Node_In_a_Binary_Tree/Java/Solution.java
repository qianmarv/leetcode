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
    //Memory Usage: 36.4 MB, less than 5.39%
    public int findSecondMinimumValue(TreeNode root) {
        if(root == null || root.left == null || root.right == null) return -1;
        int leftVal = root.left.val;
        int rightVal = root.right.val;
        if(leftVal == root.val) leftVal = findSecondMinimumValue(root.left);
        if(rightVal == root.val) rightVal = findSecondMinimumValue(root.right);
        if(leftVal != -1 && rightVal != -1) return Math.min(leftVal, rightVal);
        if(leftVal != -1) return leftVal;
        return rightVal;
    }
}
