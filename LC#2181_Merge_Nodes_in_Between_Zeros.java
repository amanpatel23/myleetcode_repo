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
    public ListNode mergeNodes(ListNode head) {
        
        ListNode fake_head = new ListNode(-1), temp = head.next, temp2 = fake_head;
        int sum = 0;
        while (temp != null) {
            if (temp.val == 0) {
                temp2.next = new ListNode(sum);
                sum = 0;
                temp2 = temp2.next;
                temp = temp.next;
                continue;
            }
            
            sum += temp.val;
            temp = temp.next;
        }
        
        return fake_head.next;
    }
}