class Solution {
    /**
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode curr = head;
        int len = 0;

        //  First pass - Traverse the entire linked list to find its total length
        while (null != curr) {
            curr = curr.next;
            len++;
        }

        // Calculate the exact position (from the start) of the node to remove from 0
        int removeIndex = len - n;

        // If removeIndex is 0, we just return the second node, effectively dropping the head.
        if (removeIndex == 0) {
            return head.next;
        }

        //  Reset the pointer back to the start of the list for the second pass
        curr = head;

        //  Second pass - Move the pointer to the node strictly BEFORE the one we want to delete.
        // We stop when removeIndex is 1, placing 'curr' exactly one node before the target.
        while (removeIndex > 1) {
            curr = curr.next;
            removeIndex--;
        }

        //  Delete the target node by routing the 'next' pointer completely around it
        curr.next = curr.next.next;

        return head;
    }

    *
  */

    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode slow = head;
        ListNode fast = head;

        while (n > 0) {
            fast = fast.next;
            n--;
        }

        // If fast hit null here, n was exactly the length of the list.
        if (fast == null) {
            return head.next;
        }

        // This stops 'slow' exactly ONE node BEFORE the target node.
        while (fast.next != null) {
            slow = slow.next;
            fast = fast.next;
        }
        // 1. 2 3 4 5 -null
        slow.next = slow.next.next;

        return head;
    }
}