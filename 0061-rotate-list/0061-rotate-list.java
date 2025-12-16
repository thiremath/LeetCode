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
    public ListNode rotateRight(ListNode head, int k) {
        ListNode root = head;
        int n = 0;

        if(root == null) return root;

        while(root!=null){
            root = root.next;
            n++;
        }

        root = head;

        k = k % n;

        if(k == 0) return head;

        int idx = n - k - 1;

        while(idx-- != 0){
            root = root.next;
        }

        ListNode newHead = root.next;
        root.next = null;
        root = newHead;

        while(root.next != null){
            root = root.next;
        }

        root.next = head;

        return newHead;
    }
}