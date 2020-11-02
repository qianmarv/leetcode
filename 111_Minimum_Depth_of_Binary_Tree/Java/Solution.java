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
    //DFS
    //Runtime: 5 ms, faster than 28.61%
    //Memory Usage: 60.1 MB, less than 6.58%
    public int minDepthDFS(TreeNode root) {
        if(root == null) return 0;
        if(root.left == null && root.right == null) return 1;
        int l = Integer.MAX_VALUE;
        int r = Integer.MAX_VALUE;
        if(root.left != null) l= minDepth(root.left) + 1;
        if(root.right != null) r = minDepth(root.right) + 1;
        return Math.min(l, r);
    }
    //BFS
    //Runtime: 0 ms, faster than 100.00%
    //Memory Usage: 59.3 MB, less than 6.58%
    public int minDepth(TreeNode root) {
        if(root == null) return 0;
        Queue<TreeNode> nodes = new LinkedList<>();
        nodes.add(root);
        int ret = 0;
        while(!nodes.isEmpty()){
            int size = nodes.size();
            ret ++;
            while(size-- > 0){
                TreeNode node = nodes.poll();
                if(node.left == null && node.right == null) return ret;
                if(node.left  != null) nodes.add(node.left);
                if(node.right != null) nodes.add(node.right);
            }
        }
        return ret;
    }
}
