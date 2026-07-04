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
// 1,2,3,4,5,6,7,8 -null
//

class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode curr = head;
        int len = 0;

        while (null != curr) {
            curr = curr.next;
            len++;
        }


        int removeIndex = len - n;
        if (removeIndex == 0) {
            return head.next;
        }
        curr = head;
        
        while(removeIndex>1){
            curr = curr.next;
            removeIndex--;
        }
       
            
        curr.next= curr.next.next; 

        return head;

    }
    
}
