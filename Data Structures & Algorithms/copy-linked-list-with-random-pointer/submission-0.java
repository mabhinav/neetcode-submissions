/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {
        if (head == null) {
            return null;
        }

        // create copy of node after each node in the same list with next
        Node curr = head;
        while (curr != null) {
            Node copy = new Node(curr.val);
            copy.next = curr.next;
            curr.next = copy;
            curr = copy.next;
        }

        // link random node in copied list
        curr = head;
        while (curr != null) {
            if (curr.random != null) {
                curr.next.random = curr.random.next;
            }
            curr = curr.next.next;
        }

        // separate the two list
        Node dummy = new Node(0);
        Node currCopy = dummy;
        curr = head;
        while (curr != null) {
            currCopy.next = curr.next;
            curr.next = curr.next.next;
            curr = curr.next;
            currCopy = currCopy.next;
        }

        return dummy.next;
    }
}
