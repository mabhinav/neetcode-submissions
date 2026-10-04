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
    public boolean hasCycle(ListNode head) {
        ListNode singleJump = head;
        ListNode doubleJump = head;

        while (doubleJump != null && doubleJump.next != null) {
            singleJump = singleJump.next;
            doubleJump = doubleJump.next.next;

            if (singleJump == doubleJump) {
                return true;
            }
        }

        return false;
    }
}
