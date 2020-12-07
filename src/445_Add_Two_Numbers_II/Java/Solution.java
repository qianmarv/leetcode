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

// Result: Success
// Runtime: 1 ms, faster than 100.00% of Java online submissions for Add Two Numbers II.
// Memory Usage: 39.6 MB, less than 68.22% of Java online submissions for Add Two Numbers II.
class Solution_1 {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        l1 = reverseList(l1);
        l2 = reverseList(l2);

        ListNode curr   = null;
        int sum         = 0;
        int carrier     = 0;
        while(l1 != null || l2 != null || carrier > 0){
            sum = 0;
            if(l1 != null){
                sum += l1.val;
                l1 = l1.next;
            }
            if(l2 != null){
                sum += l2.val;
                l2 = l2.next;
            }

            sum += carrier;
            carrier = 0;

            if(sum >= 10){
                sum    -= 10;
                carrier = 1;
            }

            ListNode node = new ListNode(sum, curr);
            curr =  node;
        }
        return curr;
    }
    private ListNode reverseList(ListNode head){
        ListNode prev = null;
        ListNode next;
        ListNode curr = head;
        while(curr != null){
            next      = curr.next;
            curr.next = prev;
            prev      = curr;
            curr      = next;
        }
        return prev;
    }
}

// Result: Success
// Runtime: 4 ms, faster than 46.32% of Java online submissions for Add Two Numbers II.
// Memory Usage: 40 MB, less than 32.76% of Java online submissions for Add Two Numbers II.
class Solution_2 {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        Stack<Integer> s1 = new Stack<Integer>();
        Stack<Integer> s2 = new Stack<Integer>();
        while(l1 != null){
            s1.push(l1.val);
            l1 = l1.next;
        }
        while(l2 != null){
            s2.push(l2.val);
            l2 = l2.next;
        }
        int sum;
        int carrier = 0;
        ListNode curr = null;
        while (!s1.empty() || !s2.empty() || carrier > 0){
            sum = 0;
            if(!s1.empty()) sum += s1.pop();
            if(!s2.empty()) sum += s2.pop();
            sum += carrier;
            carrier = 0;
            if(sum >= 10){
                sum = sum - 10;
                carrier = 1;
            }
            ListNode node = new ListNode(sum, curr);
            curr = node;
        }
        return curr;
    }
}
