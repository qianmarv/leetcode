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
    //Memory Usage: 37.4 MB, less than 40.01%
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> ret = new ArrayList<>();
        if(root == null) return ret;
        Stack<TreeNode> nodes = new Stack<>();
        nodes.push(root);
        while(!nodes.isEmpty()){
            TreeNode node = nodes.pop();
            ret.add(node.val);
            if(node.right != null) nodes.push(node.right);
            if(node.left  != null) nodes.push(node.left);
        }
        return ret;
    }
}
