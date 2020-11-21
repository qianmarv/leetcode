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
    public ListNode sortList(ListNode head) {
        return mergeSortBottomUp(head);
    }

    //Bottom-Up
    private ListNode mergeSortBottomUp(ListNode head){
        if(head == null || head.next == null) return head;
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        //get length
        int len = 0;
        ListNode tmp = head;
        while(tmp != null){
            len++;
            tmp = tmp.next;
        }

        for(int step = 1; step < len; step <<= 1){
            ListNode curr   = dummy.next, prev = curr;
            ListNode sorted = dummy;
            while(curr != null){
                //part 1
                ListNode head1 = curr;
                for(int i = 0; i < step && curr != null; i++){
                    prev = curr;
                    curr = curr.next;
                }
                prev.next = null;
                //part 2
                ListNode head2 = curr;
                for(int i = 0; i < step && curr != null; i++){
                    prev = curr;
                    curr = curr.next;
                }
                prev.next = null;
                //merge
                sorted.next = merge(head1, head2);
                while(sorted.next != null) sorted = sorted.next;
            }
        }
        return dummy.next;
    }

    //Top-Bottom
    private ListNode mergeSortTopBottom(ListNode head){
        if(head == null || head.next == null) return head;
        ListNode fast = head;
        ListNode slow = head;
        ListNode prev  = null;
        while(fast != null && fast.next != null){
            fast = fast.next.next;
            prev = slow;
            slow = slow.next;
        }
        prev.next = null;
        return merge(mergeSortTopBottom(head), mergeSortTopBottom(slow));
    }
    private ListNode merge(ListNode sorted1, ListNode sorted2){
        if(sorted1 == null) return sorted2;
        if(sorted2 == null) return sorted1;
        ListNode head = null, curr = null;
        while(sorted1 != null && sorted2 != null){
            ListNode tmp;
            if(sorted1.val < sorted2.val){
                tmp = sorted1;
                sorted1 = sorted1.next;
            }else{
                tmp = sorted2;
                sorted2 = sorted2.next;
            }
            if(curr == null) head = tmp;
            else {
                curr.next = tmp;
            }
            curr = tmp;
        }
        curr.next = sorted1 == null ? sorted2 : sorted1;
        return head;
    }
    //Time limit Exceeded
    private ListNode primitiveSort(ListNode head){
        ListNode sorted = null;
        while(head != null){
            ListNode cur = sorted;
            ListNode pre = null;
            while(cur != null && cur.val < head.val ) {
                pre = cur;
                cur = cur.next;
            }
            ListNode unsorted = head.next;
            head.next = cur;
            if(pre == null){
                sorted = head;
            }else{
                pre.next = head;
            }
            head = unsorted;
        }
        return sorted;
    }
}
