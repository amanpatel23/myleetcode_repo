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
    public ListNode removeNodes(ListNode head) {
        
        int n = 0;
        ListNode temp = head;
        while (temp != null) {
            n++;
            temp = temp.next;
        }
        int[] arr = new int[n];
        int i = 0;
        temp = head;
        while (temp != null) {
            arr[i++] = temp.val;
            temp = temp.next;
        }
        for (i = n - 2; i >= 0; i--) {
            arr[i] = Math.max(arr[i + 1], arr[i]);
        }
        
        ListNode fakeHead = new ListNode(-1);
        fakeHead.next = head;
        i = 0;
        ListNode prev = fakeHead;
        temp = head;
        while (temp != null) {
            if (temp.val < arr[i++]) {
                prev.next = temp.next;
                temp.next = null;
                temp = prev.next;
            } else {
                prev = temp;
                temp = temp.next;
            }
        }
        
        return fakeHead.next;
    }
}