/**
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode() {}
 * ListNode(int val) { this.val = val; }
 * ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */

class Solution {
    
    /**
     * VISUAL TRACE OF POINTERS
     * Imagine the list: [1] -> [2] -> [3] -> null
     * * --- INITIAL STATE ---
     * prev = null
     * curr = [1] -> [2] -> [3]
     * * --- ITERATION 1 (curr = 1) ---
     * temp = curr.next     | temp = [2]
     * curr.next = prev     | [1] -> null                  (Link reversed!)
     * prev = curr          | prev = [1] -> null
     * curr = temp          | curr = [2] -> [3]
     * * --- ITERATION 2 (curr = 2) ---
     * temp = curr.next     | temp = [3]
     * curr.next = prev     | [2] -> [1] -> null           (Link reversed!)
     * prev = curr          | prev = [2] -> [1] -> null
     * curr = temp          | curr = [3] -> null
     * * --- ITERATION 3 (curr = 3) ---
     * temp = curr.next     | temp = null
     * curr.next = prev     | [3] -> [2] -> [1] -> null    (Link reversed!)
     * prev = curr          | prev = [3] -> [2] -> [1] -> null
     * curr = temp          | curr = null                  (Loop ends!)
     * * RETURN prev: [3] -> [2] -> [1] -> null
     */
    public ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;
        ListNode temp = null;
        
        while (curr != null) {
            // 1. Save the next node so we don't lose the rest of the list
            temp = curr.next;
            
            // 2. Flip the arrow to point backwards
            curr.next = prev; 
            
            // 3. Shift 'prev' forward to the current node
            prev = curr;
            
            // 4. Shift 'curr' forward to the next node in the original list
            curr = temp;
        }

        // At the end, 'curr' is null, and 'prev' is the new head of the reversed list
        return prev;
    }
}