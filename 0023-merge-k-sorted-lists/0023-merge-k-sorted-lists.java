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

        PriorityQueue<ListNode> pq = new PriorityQueue<>((a, b) -> Integer.compare(a.val, b.val));

        ListNode ans = new ListNode();
        ListNode ret = ans;

        for(ListNode list: lists){
            if(list != null){
                pq.add(list);
            }
        }

        while(pq.size() > 0){
            ListNode curr = pq.poll();
            ans.next = curr;
            ans = curr;
            if(curr.next != null){
                pq.add(curr.next);
            }
        }

        return ret.next;
    }
}