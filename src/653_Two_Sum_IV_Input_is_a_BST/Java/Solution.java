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
    //Runtime: 2 ms, faster than 97.35%
    //Memory Usage: 40.2 MB, less than 49.32%
    public boolean findTarget(TreeNode root, int k) {
        return find(root, k, new HashSet<Integer>());
    }

    private boolean find(TreeNode node, int k, Set<Integer> set){
        if(node == null) return false;
        if(set.contains(k - node.val)) return true;
        set.add(node.val);
        return find(node.left, k, set) || find(node.right, k, set);
    }
}
