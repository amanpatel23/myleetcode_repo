/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public void deleteNode(ListNode node) {
        ListNode curr = node, nn = node.next;
        while (true) {
            int temp = curr.val;
            curr.val = nn.val;
            nn.val = temp;
            if (nn.next == null) {
                curr.next = null;
                break;
            }
            curr = nn;
            nn = nn.next;
        }
    }
}