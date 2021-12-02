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
    public ListNode oddEvenList(ListNode head) {
        
        int n = 0;
        ListNode temp = head;
        while (temp != null) {
            n++;
            temp = temp.next;
        }
        
        if (n < 3)
            return head;
        
        ListNode ptr1 = head, ptr2 = head.next.next;
        ListNode head2 = head.next;
        while (ptr2 != null) {
            temp = ptr1.next;
            ptr1.next = ptr2;
            ptr1 = temp;
            ptr2 = ptr2.next;
        }
        ptr1.next = null;
        
        temp = head;
        while (temp.next != null)
            temp = temp.next;
        temp.next = head2;
        
        return head;
    }
}