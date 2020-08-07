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


public class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) {
        this.val = val;
    }
    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}

class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int sum          = 0;
        int carrier      = 0;
        ListNode result  = null;
        ListNode current = null;
        ListNode prev    = null;

        while(l1 != null || l2 != null || carrier > 0){
            if(l1 != null){
                sum += l1.val;
                l1 = l1.next;
            }

            if(l2 != null){
                sum += l2.val;
                l2 = l2.next;
            }

            sum     += carrier;
            carrier  = 0;

            if(sum > 9){
                sum -= 10;
                carrier = 1;
            }

            current = new ListNode(sum);
            sum = 0;

            if(result == null){ // First Node
               result = prev = current;
            }else{
                prev.next = current;
                prev      = prev.next;
            }

        }
        return result;
    }
}
