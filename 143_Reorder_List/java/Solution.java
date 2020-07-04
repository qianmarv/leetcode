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
class Solution{
    // Runtime: 3 ms, faster than 24.08% of Java online submissions for Reorder List.
    // Memory Usage: 50 MB, less than 14.46% of Java online submissions for Reorder List.
    public ListNode reorderList(ListNode head){
        if(head == null || head.next == null){
            return head;
        }
        // Find Middle = Slow
        ListNode slow = head;
        ListNode fast = head.next;
        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode temp;
        // Reverse from Middle
        ListNode tail = null;
        ListNode curr = slow.next;
        slow.next     = null;
        while(curr != null){
            temp = curr.next;
            curr.next     = tail;
            tail = curr;
            curr = temp;
        }
        //  Combine the two Linked List
        curr = head;
        while(curr != null && tail != null){
            temp = curr.next;
            curr.next = tail;
            curr = temp;

            temp = tail.next;
            tail.next = curr;
            tail = temp;
        }
    }
}
