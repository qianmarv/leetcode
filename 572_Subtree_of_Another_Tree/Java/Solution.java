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
    //Runtime: 5 ms, faster than 97.17%
    //Memory Usage: 38.9 MB, less than 11.60%
    public boolean isSubtree(TreeNode s, TreeNode t) {
        if(s == null) return false;
        return compareFromRoot(s, t) || isSubtree(s.left, t) || isSubtree(s.right, t);
    }

    private boolean compareFromRoot(TreeNode s, TreeNode t){
        if(s == null && t == null) return true;
        else if(s == null || t == null) return false;
        else if(s.val != t.val) return false;
        return compareFromRoot(s.left, t.left) && compareFromRoot(s.right, t.right);
    }
}
