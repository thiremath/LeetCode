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
    public ListNode mergeTwoLists(ListNode node1, ListNode node2) {
        ListNode curr = new ListNode();
        ListNode ans = curr;

        while(node1 != null && node2 != null){
            if(node1.val <= node2.val){
                ans.next = node1;
                node1 = node1.next;
            }
            else{
                ans.next = node2;
                node2 = node2.next;
            }
            ans = ans.next;
        }

        if(node1 == null){
            ans.next = node2;
        }
        else{
            ans.next = node1;
        }

        return curr.next;
    }
}