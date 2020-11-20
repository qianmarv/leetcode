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
    //Runtime: 29 ms, faster than 57.40%
    //Memory Usage: 38.8 MB, less than 29.01%
    public ListNode insertionSortList(ListNode head) {
        ListNode orderedHead = null, orderedCurr, orderedPrev;
        while(head != null){
            if(orderedHead == null){
                orderedHead = head;
                head = head.next;
                orderedHead.next = null;
                continue;
            }
            orderedCurr = orderedHead;
            orderedPrev = null;
            while(orderedCurr != null && head.val > orderedCurr.val){
                orderedPrev = orderedCurr;
                orderedCurr = orderedCurr.next;
            }

            ListNode cur = head.next;
            if(orderedPrev == null){
                orderedHead = head;
            }else{
                orderedPrev.next = head;
            }
            head.next = orderedCurr;
            head = cur;
        }
        return orderedHead;
    }
}
