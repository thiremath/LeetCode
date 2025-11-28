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
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode originalRes = new ListNode();
        ListNode res = originalRes;
        ListNode list1P = list1;
        ListNode list2P = list2;

        while(list1P!=null && list2P!=null){
            if(list1P.val <= list2P.val){
                res.next = list1P;
                list1P = list1P.next;
            }
            else{
                res.next = list2P;
                list2P = list2P.next;
            }
            res = res.next;
        }

        if(list1P != null){
            res.next = list1P;
        }

        else{
            res.next = list2P;
        }

        return originalRes.next;
    }
}