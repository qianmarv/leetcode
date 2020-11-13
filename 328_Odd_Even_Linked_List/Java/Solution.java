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
class Solution {
    //Runtime: 0 ms, faster than 100.00%
    //Memory Usage: 38.8 MB, less than 53.35%
    public ListNode oddEvenList(ListNode head) {
        if(head == null || head.next == null) return head;
        ListNode evenHead = head.next;
        ListNode oddCurr  = head;
        ListNode evenCurr = evenHead;
        while(evenCurr != null && evenCurr.next != null){
            oddCurr.next = evenCurr.next;
            oddCurr = oddCurr.next;
            evenCurr.next = oddCurr.next;
            evenCurr = evenCurr.next;
        }
        oddCurr.next = evenHead;
        return head;
    }
}
