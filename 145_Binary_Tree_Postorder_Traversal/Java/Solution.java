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
    //Memory Usage: 36.8 MB, less than 99.79%
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> ret = new ArrayList<>();
        if(root == null) return ret;
        Stack<TreeNode> nodes = new Stack<>();
        nodes.push(root);
        while(!nodes.isEmpty()){
            TreeNode node = nodes.peek();
            if(node.left != null) {
                nodes.push(node.left);
                node.left = null;
                continue;
            }
            if(node.right != null){
                nodes.push(node.right);
                node.right = null;
                continue;
            }
            ret.add(node.val);
            nodes.pop();
        }
        return ret;
    }

    // Reverse changed way of preorder
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> ret = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            if (node == null) continue;
            ret.add(node.val);
            stack.push(node.left);
            stack.push(node.right);
        }
        Collections.reverse(ret);
        return ret;
    }
}
