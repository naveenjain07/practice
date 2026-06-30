class Solution {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        
        // 1. Create a fake "Dummy" node to start our new chain
        ListNode dummy = new ListNode(-1);
        ListNode tail = dummy;

        // 2. While BOTH lists still have nodes to compare...
        while (list1 != null && list2 != null) {
            
            if (list1.val <= list2.val) {
                tail.next = list1;  // Attach the smaller node to our tail
                list1 = list1.next; // Move list1 forward
            } else {
                tail.next = list2;  // Attach the smaller node to our tail
                list2 = list2.next; // Move list2 forward
            }
            
            // Move the tail forward to the node we just attached
            tail = tail.next;
        }

        // 3. If one list runs out early, just attach the rest of the other list!
        if (list1 != null) {
            tail.next = list1;
        } else {
            tail.next = list2;
        }

        // 4. Return the real start of the list (skipping our fake dummy node)
        return dummy.next;
    }
}