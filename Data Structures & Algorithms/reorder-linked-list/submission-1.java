class Solution {
    public void reorderList(ListNode head) {
        // Step 1: find mid
        ListNode slow = head;
        ListNode fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        
        ListNode midHead = slow.next;
        
       
        // This severs the first half from the second half
        slow.next = null; 

        // Step 2: reverse half mid to end list 
        ListNode prev = null;
        ListNode curr = midHead;
        ListNode temp = null;
        
        while (curr != null) {
            temp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = temp;
        }

        // Step 3: Merge the two halves
        ListNode first = head;
        ListNode second = prev;

        while (second != null) {
            ListNode temp1 = first.next;
            ListNode temp2 = second.next;

            first.next = second;
            second.next = temp1;
            first = temp1;
            second = temp2;
        }
    }
}