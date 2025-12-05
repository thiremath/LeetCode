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
    public ListNode mergeKLists(ListNode[] lists) {
        boolean areListsTraversed = true;
        ListNode minNode = null;

        for(ListNode l: lists){
            if(l != null && areListsTraversed){
                areListsTraversed = false;
            }

            // find smallest node and store in minNode
            if(l!=null && (minNode == null || minNode.val > l.val)){
                minNode = l;
            }
        }

        if(areListsTraversed) return null;

        for(int i=0;i<lists.length;i++){
            if(lists[i]!=null && lists[i].val == minNode.val){
                lists[i] = lists[i].next;
                break;
            }
        }

        minNode.next = mergeKLists(lists);

        return minNode;
    }
}