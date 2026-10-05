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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int sum = 0;
        int carry = 0;
        ListNode dummy = new ListNode();
        ListNode sumList = dummy;

        while (l1 != null && l2 != null) {
            sum = carry + l1.val + l2.val;
            carry = sum / 10;
            sum = sum % 10;

            ListNode node = new ListNode(sum);
            sumList.next = node;
            sumList = node;
            l1 = l1.next;
            l2 = l2.next;
        }
        
        while (l1 != null) {
            sum = carry + l1.val;
            carry = sum / 10;
            sum = sum % 10;

            ListNode node = new ListNode(sum);
            sumList.next = node;
            sumList = node;
            l1 = l1.next;
        }

        while (l2 != null) {
            sum = carry + l2.val;
            carry = sum / 10;
            sum = sum % 10;

            ListNode node = new ListNode(sum);
            sumList.next = node;
            sumList = node;
            l2 = l2.next;
        }

        if (carry != 0) {
            ListNode node = new ListNode(carry);
            sumList.next = node;;
        }

        return dummy.next;
    }
}
