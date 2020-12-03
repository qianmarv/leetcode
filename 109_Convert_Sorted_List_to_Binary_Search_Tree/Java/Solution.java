/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
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
    //Simulate inorder traversal
    //Runtime: 0 ms, faster than 100.00%       O(N)
    //Memory Usage: 40.4 MB, less than 18.07%  O(LogN)
    private ListNode head;
    public TreeNode sortedListToBST(ListNode head) {
        this.head = head;
        ListNode curr = head;
        // count length;
        int len = 0;
        while(curr != null){
            len++;
            curr = curr.next;
        }
        TreeNode root = _composeBST(0, len - 1);
        _fillBST(root);
        return root;
    }

    private TreeNode _composeBST(int beg, int end){
        if(beg > end) return null;
        int mid = beg + (end - beg)/2;
        return new TreeNode(-1,
                            _composeBST(beg, mid-1),
                            _composeBST(mid+1,end));
    }
    private void _fillBST(TreeNode root){
        if(root == null) return;
        _fillBST(root.left);
        root.val = head.val;
        head = head.next;
        _fillBST(root.right);
    }

    //Convert LinkedList to Array
    //Runtime: 0 ms, faster than 100.00%      O(N)
    //Memory Usage: 39.9 MB, less than 65.96% O(N)
    public TreeNode sortedListToBST2(ListNode head) {
        ListNode curr = head;

        // count length;
        int len = 0;
        while(curr != null){
            len++;
            curr = curr.next;
        }

        // convert(fill) linked list to array
        int[] arr = new int[len];
        curr = head;
        int count = 0;
        while(curr != null){
            arr[count++] = curr.val;
            curr = curr.next;
        }
       return _sortedArrayToBST(arr, 0, len-1);
    }
    private TreeNode _sortedArrayToBST(int[] nums, int beg, int end){
        if(beg > end) return null;
        int mid = beg + (end - beg) / 2;
        return new TreeNode(nums[mid],
                            _sortedArrayToBST(nums, beg, mid-1),
                            _sortedArrayToBST(nums, mid+1, end));
    }

    //Using Fast Slow Pointer to find the middle and do recursive
    //Runtime: 0 ms, faster than 100.00%       O(n*logN)
    //Memory Usage: 39.7 MB, less than 83.35%
    public TreeNode sortedListToBST1(ListNode head) {
        // Find mid, if mid is in root,
        //           if mid is in left node,
        if(head == null) return null;

        ListNode prev= null, slow = head, fast = head;
        while(fast != null && fast.next != null){
            prev = slow;
            slow = slow.next;
            fast = fast.next.next;
        }

        TreeNode root = new TreeNode(slow.val);
        TreeNode left = null, right = null;
        //handle left
        if(prev != null){
            prev.next = null;
            left = sortedListToBST(head);
        }

        //handle right
        if(slow.next != null){
           right = sortedListToBST(slow.next);
        }

       root.left  = left;
       root.right = right;
       return root;
    }
}
