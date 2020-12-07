/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    //O(Log_n)
    //Runtime: 0 ms, faster than 100.00%
    //Memory Usage: 41.1 MB, less than 94.43%
    public int countNodes(TreeNode root){
        if(root == null) return 0;
        int l = getHeight(root.left);
        int r = getHeight(root.right);
        return l == r ? (1<<l) + countNodes(root.right) :
                        (1<<r) + countNodes(root.left);

    }
    private int getHeight(TreeNode root){
        if(root == null) return 0;
        else return 1 + getHeight(root.left);
    }
    // Ordinary Algorithm - Traverse - O(n)
    //Runtime: 0 ms, faster than 100.00%
    //Memory Usage: 41.2 MB, less than 85.55%
    public int countNodes1(TreeNode root) {
        if(root == null) return 0;
        return countNodes(root.left) + countNodes(root.right) + 1;
    }
}
