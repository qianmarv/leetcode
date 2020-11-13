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
    //Runtime: 1 ms, faster than 66.46%
    //Memory Usage: 38.7 MB, less than 62.33%
    public int findBottomLeftValue(TreeNode root) {
        int ret = 0;
        Queue<TreeNode> nodes = new LinkedList<>();
        nodes.add(root);
        while(!nodes.isEmpty()){
            int size = nodes.size();
            boolean firstNode = true;
            while(size-- > 0){
                TreeNode node = nodes.poll();
                if(firstNode){
                    ret = node.val;
                    firstNode = false;
                }
                if(node.left != null) nodes.add(node.left);
                if(node.right != null) nodes.add(node.right);
            }
        }
        return ret;
    }
}
