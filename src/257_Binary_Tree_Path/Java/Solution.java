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
    //Runtime: 2 ms, faster than 81.09%
    //Memory Usage: 39.4 MB, less than 9.27%
    public List<String> binaryTreePaths(TreeNode root) {
        if(root == null) return new ArrayList<String>();
        return dfs(root, new StringBuilder());
    }

    private List<String> dfs(TreeNode root, StringBuilder prefix){
        List<String> ret = new LinkedList<>();
        prefix.append(String.valueOf(root.val));

        if(root.left == null && root.right == null) {
            ret.add(prefix.toString());
        }

        if(root.left != null){
            List<String> left = dfs(root.left, new StringBuilder(prefix.toString()).append("->"));
            for(String s: left){
                ret.add(s);
            }
        }
        if(root.right != null){
            List<String> right = dfs(root.right, new StringBuilder(prefix.toString()).append("->"));
            for(String s: right){
                ret.add(s);
            }
        }
        return ret;
    }
}
