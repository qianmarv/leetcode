
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
    //Runtime: 1 ms, faster than 96.57%
    //Memory Usage: 39.5 MB, less than 88.60%
    public List<TreeNode> generateTrees(int n) {
        if(n < 1) return new LinkedList<>();
        return generateSubTrees(1, n);
    }
    private List<TreeNode> generateSubTrees(int s, int e){
        List<TreeNode> nodes = new LinkedList<>();

        if(s > e){
            nodes.add(null);
        }

        for(int i = s; i <= e; i++){
            List<TreeNode> left  = generateSubTrees(s, i-1);
            List<TreeNode> right = generateSubTrees(i+1, e);
            for(TreeNode l: left){
                for(TreeNode r: right){
                    nodes.add(new TreeNode(i, l, r));
                }
            }
        }
        return nodes;
    }
}
