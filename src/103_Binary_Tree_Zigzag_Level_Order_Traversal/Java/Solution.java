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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> ret = new ArrayList<>();
        if(root == null) return ret;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        //1. Using Queue, always insert node from left to right
        //2. zigzag happens when inserting node values
        boolean zigzag = true;
        while(queue.size() != 0){
            int size = queue.size();
            List<Integer> level = new ArrayList<>();
            while(size-- >0){
                TreeNode node = queue.poll();
                if(node.left != null) queue.offer(node.left);
                if(node.right != null) queue.offer(node.right);
                if(zigzag) level.add(node.val);
                else level.add(0, node.val);
            }
            zigzag = !zigzag;
            ret.add(level);
        }
        return ret;
    }
}
