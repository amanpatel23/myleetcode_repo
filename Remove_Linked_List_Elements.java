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
    public ListNode removeElements(ListNode head, int val) {
        
        if (head == null)
            return null;
        
        ListNode fake_head = new ListNode(-1);
        fake_head.next = head;
        ListNode prev = fake_head, curr = head;
        while (curr != null) {
            if (curr.val == val) {
                prev.next = curr.next;
                curr.next = null;
                curr = prev.next;
                continue;
            }
            
            curr = curr.next;
            prev = prev.next;
        }
        
        return fake_head.next;
    }
}