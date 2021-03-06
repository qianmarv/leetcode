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
    //Memory Usage: 37.5 MB, less than 40.08%
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> ret = new ArrayList<>();
        if(root == null) return ret;
        Stack<TreeNode> nodes = new Stack<>();
        nodes.push(root);
        while(!nodes.isEmpty()){
            TreeNode node = nodes.peek();
            if(node.left != null){
                nodes.push(node.left);
                node.left = null;
                continue;
            }
            nodes.pop();
            ret.add(node.val);
            if(node.right != null){
                nodes.push(node.right);
            }
        }
        return ret;
    }
    //Without change structure
    //Runtime: 0 ms, faster than 100.00%
    //Memory Usage: 37.6 MB, less than 30.81%
    public List<Integer> inorderTraversal2(TreeNode root){
        List<Integer> ret = new ArrayList<>();
        if(root == null) return ret;
        Stack<TreeNode> nodes = new Stack<>();
        TreeNode curr = root;
        while(curr != null || !nodes.isEmpty()){
            while(curr != null){
                nodes.push(curr);
                curr = curr.left;
            }
            TreeNode node = nodes.pop();
            ret.add(node.val);
            curr = node.right;
        }
        return ret;
    }
}
