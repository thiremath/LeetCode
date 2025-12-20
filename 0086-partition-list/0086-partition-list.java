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
    public ListNode partition(ListNode head, int x) {
        ListNode head1 = new ListNode();
        ListNode head2 = new ListNode();
        ListNode root1 = head1;
        ListNode root2 = head2;

        while(head != null){
            if(head.val < x){
                root1.next = head;
                root1 = root1.next;
            }
            else{
                root2.next = head;
                root2 = root2.next;
            }
            head = head.next;
        }

        root2.next = null;

        if(head1.next == null){
            return head2.next;
        }

        else if(head2.next == null){
            return head1.next;
        }

        root1.next = head2.next;

        return head1.next;
    }
}