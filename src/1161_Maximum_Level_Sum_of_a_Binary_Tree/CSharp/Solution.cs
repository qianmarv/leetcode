using System;
using System.Collections;
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     public int val;
 *     public TreeNode left;
 *     public TreeNode right;
 *     public TreeNode(int val=0, TreeNode left=null, TreeNode right=null) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
public class Solution {
    public int MaxLevelSum(TreeNode root) {
        Queue<TreeNode> q = new Queue<TreeNode>();
        int maxSum = root.val;
        int maxSumLevel = 1;

        EnqueueChildren(q, root);

        int currentLevel = 1;
        while(q.Count > 0){
            currentLevel++;
            int size = q.Count;
            int currentSum = 0;

            while(size-- > 0){
                TreeNode node = q.Dequeue();
                currentSum += node.val;
                EnqueueChildren(q, node);
            }

            if(currentSum > maxSum){
                maxSum = currentSum;
                maxSumLevel = currentLevel;
            }
        }

        return maxSumLevel;
    }

    private void EnqueueChildren(Queue<TreeNode> q, TreeNode node){
        if(node == null) return;
        if(node.left != null) q.Enqueue(node.left);
        if(node.right != null) q.Enqueue(node.right);
    }
}
